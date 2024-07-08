package com.example.homearound2

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.homearound2.AuthRepository.AuthRepository
import com.example.homearound2.databinding.ActivityRegistrationBinding
import com.example.homearound2.rentmodel.ValidateEmailAddress
import com.example.homearound2.retrofit.HouseAddsInfoAPI
import com.example.homearound2.retrofit.RetrofitService
import com.example.homearound2.viewmodel.RegistrationViewModel
import com.example.homearound2.viewmodel.RegistrationViewModelFactory

class Registration : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private lateinit var mBinding: ActivityRegistrationBinding
    private lateinit var mViewModel: RegistrationViewModel //we create a new viewmodel var

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        mBinding = ActivityRegistrationBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_registration)
        mBinding.InputOfFullName.onFocusChangeListener = this
        mBinding.InputOfEmail.onFocusChangeListener = this
        mBinding.InputOfCode.onFocusChangeListener = this
        mBinding.InputOfConfirmCode.onFocusChangeListener = this

        val retrofit = RetrofitService()
        val houseaddsinfoApi = retrofit.retrofit!!.create(HouseAddsInfoAPI::class.java)  //to check again
        mViewModel = ViewModelProvider(this, RegistrationViewModelFactory(AuthRepository(houseaddsinfoApi),  //to check because it gives error .apply { RetrofitService.(houseaddsinfoApi?.save(houseaddsinfoApi)) }
        application)).get(RegistrationViewModel::class.java)    //we initializing the viewmodel

        setupObservers()   //now we are setting observers
    }

    private fun setupObservers(){   //here we will observe the Livedata
        mViewModel.getIsLoading().observe(this){

            mBinding.progressBar.isVisible = it  //when it is loading we see the progress bar and then hidden automatically
        }

        mViewModel.getIsUniqueEmail().observe(this){ //we will check if it is a unique password
            if(validateEmail(shouldUpdateView = false)){
                if(it){
                    mBinding.Email.apply {
                        if (isErrorEnabled) isErrorEnabled = false //if the email is unique
                        setStartIconDrawable(R.drawable.baseline_check_circle_24)
                        setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                    }
                }else{
                    mBinding.Email.apply {  //if the email is not unique
                        if(startIconDrawable != null) startIconDrawable = null
                        isErrorEnabled = true
                        error = "Email is already taken"

                    }
                }
            }

        }

        mViewModel.getErrorMessage().observe(this){
          //fullName, email, code
          //we create an array containing the keys above
            val formErrorKeys= arrayOf("InputOfUserName", "InputOfEmail", "InputOfCode")
            val message = StringBuilder() //we create a loop in order to project with if..else the differrent kind of errors messages
            it.map { entry ->
                if(formErrorKeys.contains(entry.key)){
                    when(entry.key){
                        "InputOfUserName"->{
                            mBinding.UserName.apply {
                                isErrorEnabled = true
                                error = entry.value
                            }
                        }
                        "InputOfEmail" ->{
                            mBinding.Email.apply {
                                isErrorEnabled = true
                                error = entry.value
                            }

                        }
                        "InputOfCode" ->{
                            mBinding.Code.apply {
                                isErrorEnabled = true
                                error = entry.value
                            }

                        }
                    }

                }else{   //else it will be displayed an error
                    message.append(entry.value).append("/n")
                }
                if(message.isNotEmpty()){  //we check if there is no empty message
                    AlertDialog.Builder(this)
                       .setIcon(R.drawable.info_24)
                        .setTitle("INFORMATION")
                        .setMessage(message)
                        .setPositiveButton("OK"){dialog, _ -> dialog!!.dismiss()}
                        .show()

                }
            }
        }
        mViewModel.getUser().observe(this){

        }
    }


    private fun validateFullName(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.InputOfFullName.text.toString()
        if (value.isEmpty()){
            errorMessage = "Απαιτείται η εισαγωγή ονοματεπώνυμου"
        }
        if(errorMessage != null){
            mBinding.FullName.apply{
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateEmail(shouldUpdateView: Boolean = true): Boolean{  //we insert a parameter in order to update the view so as not to be displayed any message in the input form
        var errorMessage: String? = null
        val value: String = mBinding.InputOfEmail.text.toString()
        if (value.isEmpty()){
            errorMessage = "Απαιτείται η εισαγωγή email"
        } else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "To email δεν ειναι σωστό"
        }
        if(errorMessage != null && shouldUpdateView){
            mBinding.Email.apply{
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.InputOfCode.text.toString()
        if (value.isEmpty()){
            errorMessage = "Απαιτείται εισαγωγή κωδικού"
        } else if(value.length < 6 ){
            errorMessage = "Ο Κωδικός πρέπει να έχει τουλ. 6 χαρακτήρες"
        }
        if(errorMessage != null){
            mBinding.Code.apply{
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.InputOfConfirmCode.text.toString()
        if (value.isEmpty()){
            errorMessage = "Απαιτείται εισαγωγή κωδικού επαλήθευσης"
        } else if(value.length < 6 ){
            errorMessage = "Ο Κωδικός επαλήθευσης πρέπει να έχει τουλ. 6 χαρακτήρες"
        }
        if(errorMessage != null){
            mBinding.ConfirmCode.apply{
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    private fun confirmPasswordAndConfirmpassword(): Boolean{
        var errorMessage: String? = null
        val password: String = mBinding.InputOfCode.text.toString()
        val confirmPassword: String = mBinding.InputOfConfirmCode.text.toString()
        if (password !=confirmPassword){
            errorMessage = "Ο Κωδικός επαλήθευσης δεν ίδιος με τον αρχικό"
        }
        if(errorMessage != null){
            mBinding.ConfirmCode.apply{
                isErrorEnabled = true
                error=errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view !=null){
            when (view.id){
                R.id.InputOfFullName -> {
                     if(hasFocus){
                         if(mBinding.FullName.isErrorEnabled){
                             mBinding.FullName.isErrorEnabled = false
                         }
                     }else{
                         validateFullName()
                     }
                }
                R.id.InputOfEmail -> {
                    if(hasFocus){
                        if(mBinding.Email.isErrorEnabled){
                            mBinding.Email.isErrorEnabled = false
                        }
                    }else{
                        if(validateEmail()){ //validation is needed for the uniqueness of email
                            mViewModel.validateEmailAddress(ValidateEmailAddress(mBinding.InputOfEmail.text!!.toString()))
                            //we take the input foe validation
                        }

                    }
                }
                R.id.InputOfCode -> {
                    if(hasFocus){
                        if(mBinding.Code.isErrorEnabled){
                            mBinding.Code.isErrorEnabled = false
                        }
                    }else{
                            if(validatePassword() && mBinding.InputOfConfirmCode.text!!.isNotEmpty() && validateConfirmPassword() && confirmPasswordAndConfirmpassword()){
                            if(mBinding.ConfirmCode.isErrorEnabled){
                                mBinding.ConfirmCode.isErrorEnabled = false
                            }
                            mBinding.ConfirmCode.apply {
                                setStartIconDrawable(R.drawable.baseline_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))}
                        }
                    }
                }
                R.id.InputOfConfirmCode -> {
                    if(hasFocus){
                        if(mBinding.ConfirmCode.isErrorEnabled){
                            mBinding.ConfirmCode.isErrorEnabled = false
                        }
                    }else{
                        if(validateConfirmPassword() && validatePassword() && confirmPasswordAndConfirmpassword()){
                            if(mBinding.Code.isErrorEnabled){
                                mBinding.Code.isErrorEnabled = false
                            }
                            mBinding.ConfirmCode.apply {
                                setStartIconDrawable(R.drawable.baseline_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))}
                        }
                    }
                }

            }
        }
    }

    override fun onKey(view: View?, event: Int, KeyEvent: KeyEvent?): Boolean {
        return false
    }
}

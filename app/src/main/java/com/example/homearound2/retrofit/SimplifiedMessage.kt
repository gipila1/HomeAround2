package com.example.homearound2.retrofit

import org.json.JSONException
import org.json.JSONObject

object SimplifiedMessage {
    fun get(stringMessage: String): HashMap<String, String>{
        val messages = HashMap<String,String>()
        val jsonObject = JSONObject(stringMessage)

        try{
            val JsonMessages = jsonObject.getJSONObject("message")
            JsonMessages.keys().forEach{ messages[it] = JsonMessages.getString(it)}  //so with this our message are populated into a HashMap
        }catch (e: JSONException){
             messages["message"]= jsonObject.getString("message")
        }
        return messages

    }
}
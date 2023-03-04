package com.example.jettriviaorg.model


import com.google.gson.annotations.SerializedName

class ResponseJson : ArrayList<ResponseJson.ResponseJsonItem>(){
    data class ResponseJsonItem(
        @SerializedName("answer")
        val answer: String, // True
        @SerializedName("category")
        val category: String, // world
        @SerializedName("choices")
        val choices: List<String>,
        @SerializedName("question")
        val question: String // LFD2 was banned in Australia.
    )
}
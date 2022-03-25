package com.sample.gilebeautysalon.models

data class Services(val responseCode: Int, val data: List<Data>)
data class Data(val id:Int, val name:String, val price: Double, val image:String)



package de.jonashoehn.carrental.model

open class Vehicle(
    var id: String, var brand:String, var model:String, var vinNumber: Long,
    var kfzKennzeichen:String, var sitze:Int, var farbe:String, var gewicht:Int) {

    var verleihinformation = Verleihinfo("In Shop", "", "")
}
package de.jonashoehn.carrental.model

open class PKW(id: String, brand:String, model:String, vinNumber: Long,
               kfzKennzeichen:String, sitze:Int, farbe:String, gewicht:Int, var doors:Int): Vehicle(id, brand, model,vinNumber,
 kfzKennzeichen,  sitze,  farbe,  gewicht) {
}
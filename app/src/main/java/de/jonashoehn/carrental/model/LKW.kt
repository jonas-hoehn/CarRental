package de.jonashoehn.carrental.model

class LKW(id: String, brand:String, model:String, vinNumber: Long,
          kfzKennzeichen:String, sitze:Int, farbe:String, gewicht:Int, doors:Int, var flaeche:Boolean): PKW(id, brand, model, vinNumber,
    kfzKennzeichen, sitze, farbe, gewicht, doors) {

}
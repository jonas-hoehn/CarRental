package de.jonashoehn.carrental.model

class Amphibienfahrzeug(id: String, brand:String, model:String, vinNumber: Long,
                        kfzKennzeichen:String, sitze:Int, farbe:String, gewicht:Int, var doors:Int, var tiefgang: Int):Vehicle(id ,  brand,  model, vinNumber, kfzKennzeichen, sitze, farbe, gewicht) {
}
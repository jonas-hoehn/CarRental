package de.jonashoehn.carrental.model

class Motorrad(id: String, brand:String, model:String, vinNumber: Long,
               kfzKennzeichen:String, sitze:Int, farbe:String, gewicht:Int):Vehicle(id, brand, model,vinNumber,
    kfzKennzeichen,  sitze,  farbe,  gewicht){
}

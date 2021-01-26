package fr.isen.bonnefoi.androiderestaurant

class Item {
    lateinit var nom : String
    lateinit var prix : String
    lateinit var category : String
    lateinit var description : String
    lateinit var image : String

    constructor(name : String){
        this.nom = name;
    }
}
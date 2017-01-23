package com.ynov.tp;

// PART 4 - "Créez un nouveau type Chest implémentant cette interface et retournant comme butin un « collier »."
public class Chest implements Lootable {
    // La méthode "String getLoot" est bien définie et on dit ce qu'elle fait (= retourner la chaine de caractère "collier") !
    @Override
    public String getLoot() {
        return "collier";
    }
}

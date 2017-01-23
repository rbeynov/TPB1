package com.ynov.tp;

// PART 4 - "Créez une interface Lootable définissant un comportement getLoot."
public interface Lootable {
    /*
     * PART 4 - "La méthode getLoot retourne une chaine de caractère (correspondant à un butin)"
     * La méthode est ABSTRACT et PUBLIC:
     *      - La méthode "getLoot()" devra être définie (qu'est-ce qu'elle fait?) dans toutes les classes qui implémentent l'interface "Lootable".
     *          C'est dans la classe en question qu'on devra donc retourner le fameux butin !
     *      - La classe qui l'implémentera exposera forcement la méthode. On pourra appeler "getLoot()" sur toutes les instances de classes qui implémentent "Lootable"
     *  Les mots clés ABSTRACT et PUBLIC sont implicites, inutiles donc de les indiquer devant la méthode. Le faire est néanmoins valide (juste redondant).
     */
    String getLoot();
}

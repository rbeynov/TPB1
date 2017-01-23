package com.ynov.tp;

import java.util.*;

public class Shop {
    // PART 5 - "Un magasin disposera d’une map associative qui va lier des biens (sous forme de chaine de caractère) à des prix."
    private Map<String, Integer> items;

    public Shop() {
        // Initialisation de la liste des items en créant une nouvelle instance de HashMap que l'on associe à l'attribut
        items = new HashMap<>();
    }

    /*
     * PART 5 - "La méthode addItemToShop prend en paramètre un bien (chaine de caractère), et un prix. Elle ajoute cette combinaison clé/valeur dans la map."
     */
    public void addItemToShop(String anItem, Integer price) {
        System.out.println("Ajout de l'objet "+anItem+" d'une valeur de "+price+"€ au magasin.");
        items.put(anItem, price); // Ajoute un élément de clé "anItem" et de valeur "price"
    }

    /*
     * PART 5 - "La méthode getItemsCheaperThan prend en paramètre un montant et retourne une liste de bien (chaine de caractère) dont le prix est inférieur à ce montant."
     */
    public List<String> getItemsCheaperThan(int aPrice) {

        // Créer une liste vide qui va être retourné en résultat de la méthode. Elle va contenir tous les produits dont le prix est inférieur au montant passé en paramètre.
        List<String> cheapitems = new ArrayList<>();

        // On récupère l'ensemble des biens du magasin (liste des clés de la map)
        Set<String> completListOfItems = items.keySet();

        // On parcours chaque item du magasin
        for(String anItem : completListOfItems) {
            // On récupère le prix de l'item pour l'itération actuelle
            Integer priceOfTheItem = items.get(anItem);

            // On ajoute l'item en question à la liste des biens qui va être retournée par la méthode si son prix le prix est inférieur au montant passé en paramètre.
            if(priceOfTheItem <= aPrice) {
                cheapitems.add(anItem);
            }
        }

        return cheapitems;
    }
}

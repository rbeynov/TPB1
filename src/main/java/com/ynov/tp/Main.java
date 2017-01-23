package com.ynov.tp;

import java.util.List;

public class Main {

    // PART 1 - "Créez une classe Main disposant d’une méthode public static void main(String[] args), point d’entrée de votre programme."
    public static void main(String[] args) {
        // PART 1 - "A l’intérieur, créez et initialisez les instances afin d’obtenir les objets suivants:"

        /*
         * Armes :
         *      Nom : Arc / Type : distant / Dégats : 10
         *      Nom : Épée / Type : mélée / Dégats : 13
         *      Nom : Baton / Type : magique / Dégats : 23
         */
        Weapon epee = new Weapon("Épée", WeaponType.MELEE, 13);
        Weapon baton = new Weapon("Baton", WeaponType.MAGICAL, 23);

        /*
         * Joueurs :
         *      Nom : Conan / Points de vie : 200 / Expérience : 13 / Arme : épée
         *      Nom : Gandalf / Points de vie : 120 / Expérience : 25 / Arme : baton
         */
        Player conan = new Player("Conan", 200);
        conan.setWeapon(epee);
        conan.setXp(13);

        Player gandalf = new Player("Gandalf", 120);
        gandalf.setWeapon(baton);
        gandalf.setXp(25);

        /*
         * Monstres :
         *      Nom : Cafard / Points de vie : 30 / Dégats : 10
         *      Nom : Loup / Points de vie : 70 / Dégats : 20
         *      Nom : Dragon / Points de vie : 170 / Dégats : 100
         */
        Monster loup = new Monster("Loup", 20, 70);
        Monster dragon = new Monster("Dragon", 100, 170);

        // PART 2 - "Pour chaque monstre et joueurs, affichez ses informations en console :"
        // Pour utiliser la méthode describe() depuis une instance de joueur, il faudrait que je gère les exceptions levées par cette méthode
        // (à savoir "PlayerDeadException"), cf plus bas.
        // conan.describe();
        // gandalf.describe();
        loup.describe();
        dragon.describe();

        /*
         * PART 3 - "Testez votre logique métier en demandant à gandalf d’attaquer le loup puis à conan d’attaquer le dragon dans votre main."
         */
        gandalf.attaquer(loup);
        System.out.println("");
        conan.attaquer(dragon);

        /*
         * PART 4 - "Créez une instance de Chest dans le main.
         * Faites en sorte que Gandalf récupère un butin (looter) depuis l’instance de coffre créée précédemment puis récupère un nouveau butin sur le dragon."
         * aChest est une instance de Chest, donc c'est une instance d'un type "Lootable" (puisque Chest implémente l'interface Lootable).
         * dragon est une instance de Monster, donc c'est une instance d'un type "Lootable" (puisque Monster implémente l'interface Lootable).
         */
        Chest aChest = new Chest();
        gandalf.looter(aChest);
        gandalf.looter(dragon);

        // PART 5 - "Créez une instance de magasin dans le main."
        Shop aShop = new Shop();

        /*
         * Biens :
         *      Armure - 50€
         *      Potion - 10€
         *      Cheval - 200€
         */
        aShop.addItemToShop("Armure", 50);
        aShop.addItemToShop("Potion", 10);
        aShop.addItemToShop("Cheval", 200);

        // PART 5 - "Récupérez depuis votre magasin la liste des biens dont le prix est inférieur à 100€ et affichez la en console."
        List<String> itemsCheaperThanOneHundredEuros = aShop.getItemsCheaperThan(100);
        for(String anItem : itemsCheaperThanOneHundredEuros) {
            System.out.println("Pour moins de 100€ je peux avoir dans mon magasin un "+anItem);
        }


        /*
         * PART 6 - "Pour tester le principe, créez la nouvelle instance de Player suivante et demandez-lui de se décrire :
         *      Nom : Noob / Points de vie : 0 / Expérience : 0 / Arme : distante"
         */
        Player noob = new Player("Noob", 0);

        try {
            noob.describe();
        } catch (PlayerDeadException e) {
            // "Lorsqu’une exception PlayerDeadException est levée, affichez en console un message stipulant que le joueur est mort et qu’il ne peut pas se décrire."
            Player deadPlayer = e.getDeadPlayer();
            System.out.println("Le joueur "+deadPlayer.getName()+" ne peut pas se décrire puisqu'il est mort.");
        }
    }

}

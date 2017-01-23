package com.ynov.tp;

// PART 4 - "Implémentez cette interface au niveau du type Monster qui retournera comme butin un « morceau de cuir »."
public class Monster implements Lootable {
    // PART 1 - "Un monstre disposera d’un nom, d’un nombre de point de dégâts et d’un nombre de points de vie."
    private String name;
    private int damages;
    private int hp;

    // PART 1 - "La classe monstre doit être instanciée avec un nom, un nombre de points de vie et un nombre de point de dégâts."
    // Constructeur unique
    public Monster(String name, int damages, int hp) {
        this.name = name;
        this.damages = damages;
        this.hp = hp;
    }

    /*
     * Getters et setters qui exposent les propriétés privées que l'on souhaite.
     * PART 1 - "Une fois définis lors de la construction d’une instance, ces valeurs ne pourront être changées."
     * ==> Aucun setter !
     * Les propriétés sont en privés, elles sont donc intouchables en dehors de l'instance en elle même = on ne peut les modifier que via des méthodes comme looseHp() par exemple...
     */
    public String getName() {
        return name;
    }

    public int getDamages() {
        return damages;
    }

    public int getHp() {
        return hp;
    }

    // PART 3 - "La méthode looseHp permet de diminuer les points de vie du monstre par la valeur passée en paramètre (nommée "amount")."
    public void looseHp(int amount) {
        hp -= amount;
    }

    /*
     * PART 1 - "La méthode describe affichera en console des informations sur le nom du monstre, son nombre de point de vie et les dégâts qu’il inflige."
     */
    public void describe() {
        System.out.println("Je suis un "+name+" ("+hp+") et je peux faire jusqu'à "+damages+" dégats.");
    }

    // PART 4 - La méthode "String getLoot" est bien définie et on dit ce qu'elle fait (= retourner la chaine de caractère "collier") !
    @Override
    public String getLoot() {
        return "morceau de cuir";
    }
}

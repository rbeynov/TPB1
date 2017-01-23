package com.ynov.tp;

public class Weapon {
    /*
     * PART 1 - "Une arme disposera d’un nom, d’un type et d’un nombre de point de dégâts."
     */
    private String name;
    private WeaponType type;
    private int damages;

    /*
     * PART 1 - "La classe arme doit être instanciée avec un nom, un type et un nombre de point de dégâts."
     * Constructeur unique = pas le choix !
     */
    public Weapon(String name, WeaponType type, int damages) {
        this.name = name;
        this.type = type;
        this.damages = damages;
    }

    /*
     * PART 1 - "Une fois définis lors de la construction d’une instance, ces valeurs ne pourront être changées."
     * ==> Aucun setter ! Les propriétés sont en privés, elles sont donc intouchables en dehors de l'instance en elle même (= on ne peut les modifier que via des méthodes par exemple...)
     */
    public String getName() {
        return name;
    }

    public WeaponType getType() {
        return type;
    }

    public int getDamages() {
        return damages;
    }
}

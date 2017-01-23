package com.ynov.tp;

import java.util.Random;

public class Player {
    /*
     * PART 1 - "Un joueur disposera d’un nombre de points de vie, d’un nombre de points d’XP, d’un nom et d’une arme."
     */
    private String name;
    private int hp;
    private long xp;
    private Weapon weapon;

    /*
     * PART 1 - "La classe joueur peut être instanciée soit avec un nom, soit avec un nom et un nombre de points de vie de départ."
     * 2 constructeurs
     */
    public Player(String name) {
        this.name = name;

        // Valeurs par défaut for the fun quand on ne créer un joueur qu'à partir d'un nom...
        this.hp = 100;
        this.xp = 0;
    }

    public Player(String name, int hp) {
        this(name); // Appelle le premier constructeur en lui passant en paramètre celui reçu
        this.hp = hp;
    }

    /*
     * Getters et setters qui exposent en lecture (=getter) et en modification (=setter) les propriétés privées que l'on souhaite.
     * PART 1 - "Une fois défini lors de la construction d’une instance, le nom du joueur ne pourra plus être changé" => Pas de setter pour name
     *
     */
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /*
     * PART 3 - "La méthode attaquer permet d’engager un combat pour le joueur courant contre un monstre donné."
     */
    public void attaquer(Monster aMonster) {
        // Le monstre attaqué est celui passé en paramètre de la méthode lors de son appelle: "aMonster"
        System.out.println("----");
        System.out.println(name+" attaque un "+aMonster.getName());
        System.out.println("----");

        // PART 3 - "vont se répéter tant que la vie du joueur ou du monstre ne sera pas tombée à 0."
        boolean joueurMort = false;
        boolean monsterMort = false;

        while(!joueurMort && !monsterMort) {
            // PART 3 - "Les dégats infligés par le joueur au monstre sont d’un montant aléatoire entre 0 et les points de dégâts de son arme."
            Random random = new Random();
            int degats = random.nextInt(weapon.getDamages());

            // PART 3 - "Il y a également une chance sur 2 que les dégâts infligés soient le double des dégâts maximales de l’arme (coup critique)."
            if(random.nextBoolean()) {
                degats = weapon.getDamages() * 2;
                System.out.print("COUP CRITIQUE ! ");
            } else {
                System.out.print("Coup normal. ");
            }
            System.out.println(name+" inflige "+degats+" points de dégats au "+aMonster.getName()+".");

            // PART 3 - "Le joueur va commencer par infliger des dégâts au monstre, faisant ainsi diminuer ses points de vie (hp)."
            aMonster.looseHp(degats);

            // PART 3 - "Le monstre va ensuite répliquer en infligeant des dégâts au joueur, faisant ainsi diminuer ses points de vie."
            System.out.println(aMonster.getName()+" inflige "+aMonster.getDamages()+" points de dégats à "+name+".");
            hp -= aMonster.getDamages();

            monsterMort = aMonster.getHp() <= 0;
            joueurMort = hp <= 0;

            // PART 3 - "Une fois l’un des deux opposants vaincus, le vainqueur est affiché en console."
            if(monsterMort) {
                // PART 3 - "S’il s’agit du joueur, son expérience augmente de 10 points."
                System.out.println("----");
                System.out.println("Le monstre est mort. "+name+" gagne 10 d'expérience.");
                System.out.println("----");
                xp += 10;
            } else if(joueurMort) {
                System.out.println("----");
                System.out.println("Le joueur est mort, son expérience tombe à 0.");
                System.out.println("----");
                xp = 0;
            }
        }
    }

    /*
     * PART 4 - "La méthode looter affiche un message en console indiquant le butin que l’on vient de récupérer sur l’argument de type Lootable passé en paramètre."
     * On peut donc passer à cette méthode, soit une instance de "Chest", soit une instance de "Monster".
     */
    public void looter(Lootable aLoot) {
        System.out.println(name+" vient de récupérer un loot ! Il s'agit d'un "+aLoot.getLoot());
    }

    /*
     * PART 1 - "La méthode describe affichera en console des informations sur le nom du joueur, son nombre de point de vie, le nom de son arme, son type et les dégâts qu’elle inflige."
     * PART 6 - "Déclarez que la méthode describe du type Player lève des exceptions de type PlayerDeadException."
     */
    public void describe() throws PlayerDeadException {
        if(hp <= 0) {
            // PART 6 - "Cette exception sera levée par la méthode describe lorsque le joueur courant est mort (hp inférieurs ou égaux à 0).
            // Cette exception devra interrompre le cycle normal de la méthode et ainsi empêcher l’affichage des informations du joueur."
            // Lève une exception (nouvelle instance de PlayerDeadException), en lui passant en paramètre le joueur concerné par l'exception (le joueur courant)
            throw new PlayerDeadException(this);
        }
        System.out.println("Je suis "+name+" ("+hp+") et je peux faire jusqu'à "+weapon.getDamages()+" dégats avec mon "+weapon.getName()+" ("+weapon.getType()+").");
    }
}

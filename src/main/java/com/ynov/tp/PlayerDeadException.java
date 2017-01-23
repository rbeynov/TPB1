package com.ynov.tp;

public class PlayerDeadException extends Exception {

    // PART 6 -"L’exception disposera d’un paramètre deadPlayer correspondant au joueur mort concerné par l’exception."
    private Player deadPlayer;

    /*
     * PART 6 - "L’exception doit être instanciée avec le joueur mort concerné par l’exception."
     * Constructeur unique - pas d'autres choix
     */
    public PlayerDeadException(Player deadPlayer) {
        this.deadPlayer = deadPlayer;
    }

    // Permet à partir de l'exception levée de récupérer le joueur mort
    public Player getDeadPlayer() {
        return deadPlayer;
    }
}

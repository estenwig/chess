package esben.chess.core;


import esben.chess.core.model.Game;

public class Main {
    public Main() {
        // Sette opp spillere. Mennesklige eller Ai.
        // Brett Board
        // Tallene på brettet representerer rader.
        // Bokstavene på brettet representerer linjer.
        Game game = new Game();

        new StandardInitializer().initialize(game.getBoard());
        System.out.println(game);
    }

    public static void main(String[] args) {
        new Main();
    }
}

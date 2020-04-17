package SODOKU;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.loadGame();
        game.showGame();
//        game.winGame();
        System.out.println("choi di cac ban!");
        while (!game.winGame()) {
            game.tick();

            game.showGame();
            if(game.winGame()){
                System.out.println("chúc mừng con vợ đã chiến thắng nha!");
            }
        }
    }
}

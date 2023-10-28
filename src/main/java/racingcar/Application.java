package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //String userInput = Console.readLine();
        //String[] carName = getCarName(userInput);

        //RacingcarGame game = new RacingcarGame(List.of(carName));
        //game.gameStart();


        //RacingcarGame gameManager = new RacingcarGame();
        //while (gameManager.gameOver()) {
            //gameManager.gameStart();

        RacingcarGame gameManager = new RacingcarGame();
        while (gameManager.gameOver()) {
            gameManager.gameStart();

        }
    }
}

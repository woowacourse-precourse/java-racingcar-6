package racingcar;

import java.util.HashMap;
import racingcar.Game.Controller;
import racingcar.View.SystemOutput;
import racingcar.View.UserInput;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller();
        UserInput userInput = new UserInput();
        SystemOutput systemOutput = new SystemOutput();

        HashMap<String, Integer> scoreBoard = controller.createScoreBoard();

        int round = userInput.Round();

        SystemOutput.printGameResult();

        while (round != 0) {
            scoreBoard = controller.carMove(scoreBoard);
            systemOutput.printScore(scoreBoard);
            round--;
        }

        systemOutput.printWinner(controller.findWinner(scoreBoard));

    }
}

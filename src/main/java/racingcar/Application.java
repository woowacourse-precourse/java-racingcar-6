package racingcar;

import java.util.HashMap;
import java.util.Map;
import racingcar.Game.Controller;
import racingcar.View.UserInput;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller();
        UserInput userInput = new UserInput();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        HashMap<String, Integer> scoreBoard = controller.createScoreBoard();

        System.out.println("시도할 회수는 몇회인가요?");
        int round = userInput.Round();


        System.out.println();
        System.out.println("실행 결과");

        while (round != 0) {
            scoreBoard = controller.carMove(scoreBoard);
            for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println();
            round--;
        }

        System.out.println("최종 우승자 : "+controller.findWinner(scoreBoard));

    }
}

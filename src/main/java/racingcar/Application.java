package racingcar;

import java.util.List;
import racingcar.Game.Controller;
import racingcar.Game.UserInput;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller();
        UserInput userInput = new UserInput();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carName = userInput.CarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int round = userInput.Round();

        System.out.println();
        System.out.println("실행 결과");

        List<Integer> scoreBoard = controller.SetScoreBoard(carName);


        scoreBoard = controller.CarMove(scoreBoard);

        while (round == 0) {
            scoreBoard = controller.CarMove(scoreBoard);
            controller.PrintScore(carName, scoreBoard);
            round--;
        }
        System.out.println("최종 우승자 : "+controller.getWinner(carName,scoreBoard));
    }
}

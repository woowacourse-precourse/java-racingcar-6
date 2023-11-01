package racingcar;

import java.util.List;
import racingcar.domain.Announcer;
import racingcar.domain.Car;
import racingcar.domain.GameController;
import racingcar.domain.InputController;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        String carNames = inputController.insertCarNames();
        List<Car> carList = inputController.setCar(carNames);
        int attemptCount = inputController.insertAttemptCount();

        GameController gameController = new GameController();
        System.out.println();
        System.out.println("실행 결과");
        gameController.play(carList, attemptCount);

        Referee referee = new Referee();
        List<Car> winner = referee.identifyWinner(carList);

        Announcer announcer = new Announcer();
        StringBuffer winnerPresentation = announcer.displayWinner(winner);
        System.out.print(winnerPresentation);
    }
}

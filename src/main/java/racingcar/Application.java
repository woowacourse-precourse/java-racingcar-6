package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;
import racingcar.domain.Referee;
import racingcar.domain.Turn;

public class Application {
    public static void main(String[] args) {
        RacingCarOutputManager outputManager = new RacingCarOutputManager();
        RacingCarInputManager inputManager = new RacingCarInputManager(outputManager);

        Cars cars = new Cars(inputManager.readCarNames());

        Turn turn = new Turn(inputManager.readTryToMoveTurnCount());

        outputManager.println("\n실행 결과");
        List<Car> moveResult;
        for (int i = 0; i < turn.getCount(); i++) {
            moveResult = cars.tryToMove();
            for (Car car : moveResult) {
                outputManager.printCarPosition(car.getName(), car.getPosition());
            }
            outputManager.printEnter();
        }

        Referee referee = new Referee();
        List<String> winners = referee.judgeWinner(cars.getCurrentStatus());
        outputManager.printWinners(winners);
    }
}

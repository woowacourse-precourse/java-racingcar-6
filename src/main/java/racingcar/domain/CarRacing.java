package racingcar.domain;

import static racingcar.constant.RacingCarMessage.RACING_RESULT_MESSAGE;

import java.util.List;

public class CarRacing {
    private final RacingCarInputManager inputManager;
    private final RacingCarOutputManager outputManager;

    private CarRacing(RacingCarInputManager inputManager, RacingCarOutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public static CarRacing init(RacingCarInputManager inputManager, RacingCarOutputManager outputManager) {
        return new CarRacing(inputManager, outputManager);
    }


    public void start() {
        RacingCarOutputManager outputManager = new RacingCarOutputManager();
        RacingCarInputManager inputManager = new RacingCarInputManager(outputManager);

        Cars cars = new Cars(inputManager.readCarNames());

        Turn turn = new Turn(inputManager.readTryToMoveTurnCount());

        outputManager.println(RACING_RESULT_MESSAGE);
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

package racingcar.domain;

import static racingcar.constant.RacingCarMessage.RACING_RESULT_MESSAGE;

import java.util.List;

public class CarRacing {
    private final Cars cars;
    private final Turn turn;
    private final Referee referee;
    private final RacingCarOutputManager outputManager;

    public CarRacing(Cars cars, Turn turn, Referee referee, RacingCarOutputManager outputManager) {
        this.cars = cars;
        this.turn = turn;
        this.referee = referee;
        this.outputManager = outputManager;
    }


    public void start() {
        move(turn, cars);

        Winners winners = judgeWinners(cars);
        announceWinners(winners);
    }

    private void announceWinners(Winners winners) {
        outputManager.printWinners(winners.getWinners());
    }

    private Winners judgeWinners(Cars cars) {
        return referee.judgeWinners(cars.getCurrentStatus());
    }

    private void move(Turn turn, Cars cars) {
        outputManager.println(RACING_RESULT_MESSAGE);

        List<Car> moveResult;
        for (int i = 0; i < turn.getCount(); i++) {
            moveResult = cars.tryToMove();
            for (Car car : moveResult) {
                outputManager.printCarPosition(car.getName(), car.getPosition());
            }
            outputManager.printEnter();
        }
    }
}

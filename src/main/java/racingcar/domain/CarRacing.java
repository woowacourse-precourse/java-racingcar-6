package racingcar.domain;

import static racingcar.constant.CarRacingMessage.RACING_RESULT_MESSAGE;

import java.util.List;
import racingcar.io.CarRacingOutputProcessor;

public class CarRacing {
    private final Cars cars;
    private final Turn turn;
    private final Referee referee;
    private final CarRacingOutputProcessor outputProcessor;

    public CarRacing(Cars cars, Turn turn, Referee referee, CarRacingOutputProcessor outputProcessor) {
        this.cars = cars;
        this.turn = turn;
        this.referee = referee;
        this.outputProcessor = outputProcessor;
    }


    public void start() {
        move(turn, cars);

        Winners winners = judgeWinners(cars);
        announceWinners(winners);
    }

    private void announceWinners(Winners winners) {
        outputProcessor.printWinners(winners.getWinners());
    }

    private Winners judgeWinners(Cars cars) {
        return referee.judgeWinners(cars.getCurrentStatus());
    }

    private void move(Turn turn, Cars cars) {
        outputProcessor.println(RACING_RESULT_MESSAGE);

        List<Car> moveResult;
        for (int i = 0; i < turn.getCount(); i++) {
            moveResult = cars.tryToMove();
            for (Car car : moveResult) {
                outputProcessor.printCarPosition(car.getName(), car.getPosition());
            }
            outputProcessor.printEnter();
        }
    }
}

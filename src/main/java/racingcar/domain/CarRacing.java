package racingcar.domain;

import static racingcar.constant.CarRacingMessage.RACING_RESULT_MESSAGE;

import java.util.List;
import racingcar.io.CarRacingOutputView;

public class CarRacing {
    private final Cars cars;
    private final Turn turn;
    private final Referee referee;
    private final CarRacingOutputView outputView;

    public CarRacing(Cars cars, Turn turn, Referee referee, CarRacingOutputView outputView) {
        this.cars = cars;
        this.turn = turn;
        this.referee = referee;
        this.outputView = outputView;
    }


    public void start() {
        move(turn, cars);

        Winners winners = judgeWinners(cars);
        announceWinners(winners);
    }

    private void announceWinners(Winners winners) {
        outputView.printWinners(winners.getWinnerNames());
    }

    private Winners judgeWinners(Cars cars) {
        return referee.judgeWinners(cars.getCurrentStatus());
    }

    private void move(Turn turn, Cars cars) {
        outputView.printMessage(RACING_RESULT_MESSAGE);

        List<Car> moveResult;
        for (int i = 0; i < turn.getCount(); i++) {
            moveResult = cars.tryToMove();
            for (Car car : moveResult) {
                outputView.printCarPosition(car.getName(), car.getPosition());
            }
            outputView.printEnter();
        }
    }
}

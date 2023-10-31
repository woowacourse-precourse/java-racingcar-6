package racingcar.presentation;

import static racingcar.global.constants.MessageType.RESULT_MESSAGE;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.utils.Parser;
import racingcar.view.View;

public class RaceController {
    public void startRace() {
        Cars cars = Cars.of(View.requestCarNames());
        Integer count = Parser.parseStringToInteger(View.requestCount());
        play(cars, count);
        finish(cars);
    }

    private void play(Cars cars, Integer totalCount) {
        View.printlnMessage(RESULT_MESSAGE);
        for (int count = 0; count < totalCount; count++) {
            cars.tryMoveCars();
            View.printlnString(cars.toString());
        }
    }

    private void finish(Cars cars) {
        Winners winners = Winners.of(cars);
        View.printlnString(winners.toString());
    }
}

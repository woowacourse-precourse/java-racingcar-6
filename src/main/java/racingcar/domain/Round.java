package racingcar.domain;

import racingcar.constants.MoveTypes;
import racingcar.util.NumberGenerator;
import racingcar.util.OutputHandler;

public class Round {
    private Cars cars;
    private static final int MOVE_CRITERIA = 4;
    private static final String NEW_LINE = System.lineSeparator();
    private static final String MOVE_VALUE = MoveTypes.MOVE.getValue();

    public void start(Cars cars) {
        this.cars = cars;
        moveCars();
        showResult();
    }

    private void moveCars() {
        for (Car car : cars.getCars()) {
            if (shouldMove()) {
                car.move();
            }
        }
    }

    private boolean shouldMove() {
        Integer randomNumber = NumberGenerator.createRandomSingleNumber();
        return randomNumber >= MOVE_CRITERIA;
    }

    private void showResult() {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars.getCars()) {
            builder.append(car.getName()).append(" : ");
            builder.append(getCarMoveHistory(car));
        }
        OutputHandler.showMessage(builder.toString());
    }

    private String getCarMoveHistory(Car car) {
        StringBuilder history = new StringBuilder();
        for (int i = 0; i < car.getMoveCount(); i++) {
            history.append(MOVE_VALUE).append(NEW_LINE);
        }

        return history.toString();
    }
}

package racingcar.domain;

import static racingcar.domain.DomainConstant.CAR_MOVE;
import static racingcar.domain.DomainConstant.CAR_MOVE_CONDITION;
import static racingcar.view.RacingView.carMoveOrStopDecisionResultView;

public class Car {
    private final StringBuilder stopOrMoveDecisionResult;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
        stopOrMoveDecisionResult = new StringBuilder();
    }

    public void stopOrMoveDecision(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            stopOrMoveDecisionResult.append(CAR_MOVE);
        }
        carMoveOrStopDecisionResultView(carName, stopOrMoveDecisionResult.toString());
    }

    public String getCarName() {
        return carName;
    }

    public int calculateDistance() {
        return stopOrMoveDecisionResult.toString().length();
    }

    @Override
    public String toString() {
        return carName;
    }
}

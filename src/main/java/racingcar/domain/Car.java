package racingcar.domain;

import static racingcar.domain.DomainConstant.CAR_MOVE_CONDITION;
import static racingcar.view.RacingView.carMoveOrStopDecisionResultView;

public class Car {
    private int position;
    private final String carName;


    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public void stopOrMoveDecision(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            position++;
        }
        carMoveOrStopDecisionResultView(carName, position);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return position;
    }

    @Override
    public String toString() {
        return carName;
    }
}

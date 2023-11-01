package racingcar.domain;

import racingcar.domain.wrapper.CarName;
import racingcar.domain.wrapper.CarPosition;

import java.util.HashMap;
import java.util.Map;

import static racingcar.handler.ConstantsHandler.NUMBER_POSSIBLE_TO_FORWARD;
import static racingcar.handler.ConstantsHandler.POINT_MARK;

public class CarStatus implements Comparable<CarStatus> {

    private final Map<String, String> carStatus = new HashMap<>();
    private final CarName carName;
    private final CarPosition position;

    private CarStatus(final String carName) {
        this.carName = CarName.create(carName);
        this.position = CarPosition.create();
    }

    public static CarStatus create(final String carName) {
        return new CarStatus(carName);
    }

    public void forWard(int number) {
        if (number >= NUMBER_POSSIBLE_TO_FORWARD) {
            position.addPosition();
        }
    }

    public Map<String, String> getCarStatus() {
        String dash = POINT_MARK.repeat(position.getPosition());
        carStatus.put("carName", carName.getCarName());
        carStatus.put("position", dash);

        return carStatus;
    }

    public boolean isSamePosition(CarStatus otherCar) {
        return position.getPosition() == otherCar.position.getPosition();
    }

    @Override
    public int compareTo(CarStatus otherCar) {
        return position.getPosition() - otherCar.position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}

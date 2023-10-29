package racingcar.domain;

import static racingcar.config.Constants.MOVE_THRESHOLD;

import racingcar.dto.CarDTO;
import racingcar.utils.Utils;

public class Car {
    private final String name;
    private final Position position = new Position();

    public Car(String name) {
        this.name = name;
    }

    public CarDTO toDTO() {
        String name = this.name;
        int pos = position.getPosition();

        return new CarDTO(name, pos);
    }

    public void tryMove() {
        if (canMove()) {
            position.moveForward();
        }
    }


    // 랜덤으로 뽑은 값이 임계값보다 큰지(이동해도 되는지) 판별
    private boolean canMove() {
        int pickedNumber = Utils.generateRandomNumber();

        return pickedNumber > MOVE_THRESHOLD;
    }

}

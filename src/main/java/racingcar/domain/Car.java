package racingcar.domain;

import static racingcar.config.Constants.MOVE_THRESHOLD;
import static racingcar.config.Constants.RANGE_MAX;
import static racingcar.config.Constants.RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarDTO;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public CarDTO toDTO() {
        String name = this.name;
        int position = this.position;

        return new CarDTO(name, position);
    }

    public void tryMove() {
        if (canMove()) {
            position++;
        }
    }


    // 랜덤으로 뽑은 값이 임계값보다 큰지(이동해도 되는지) 판별
    private boolean canMove() {
        int pickedNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);

        return pickedNumber > MOVE_THRESHOLD;
    }

}

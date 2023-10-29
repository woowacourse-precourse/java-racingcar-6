package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private String carName;
    private int position = 0;


    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getPositionToString() {
        return IntStream.rangeClosed(1, this.position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return this.position;
    }
}

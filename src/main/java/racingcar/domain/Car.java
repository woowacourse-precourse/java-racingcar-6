package racingcar.domain;

import racingcar.utils.Constants;
import racingcar.utils.RandomNumber;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(CarName carName) {
        this.name = carName;
    }

    public String getName() {
        return name.getName();
    }

    public void move(int randomNumber) {
        if (RandomNumber.isMove(randomNumber)) {
            this.position++;
        }
    }

    public String resultPosition() {

        return IntStream.range(0,getPosition())
                .mapToObj(i -> Constants.DASH)
                .collect(Collectors.joining());
    }

    public int getPosition() {
        return position;
    }
}

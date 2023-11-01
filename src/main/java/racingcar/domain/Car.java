package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public static List<Car> makeCarList(List<String> carNameList) {
        return carNameList.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getPath() {
        return move;
    }

    public void moveOrStop() {
        if (isMove()) {
            move++;
        }
    }

    private boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }
}

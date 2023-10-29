package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConfig;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void action() {
        if (shouldMove()) {
            position++;
        }
    }

    private boolean shouldMove() {
        int min = GameConfig.RANDOM_NUMBER_MINIMUM.getValue();
        int max = GameConfig.RANDOM_NUMBER_MAXIMUM.getValue();
        int pickedNumber = Randoms.pickNumberInRange(min, max);

        return pickedNumber > 3;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

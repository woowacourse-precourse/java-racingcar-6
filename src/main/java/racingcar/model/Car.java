package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MaxNumber = 9;
    private final int MinNumber = 0;
    private final int MinToMove = 4;

    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(MinNumber, MaxNumber);

        if (randomNumber >= MinToMove)
            position++;
    }
}

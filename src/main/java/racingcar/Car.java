package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private StringBuilder mileage;
    private static final int MOVABLE_LOWER_BOUND = 4;
    private static final String INDICATOR_PER_MOVE = "-";


    private Car(String name) {
        this.name = name;
        this.mileage = new StringBuilder();
    }

    public static Car createCarByName(String name) {
        return new Car(name);
    }

    public void moveForwardOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isOkayToMove(randomNumber)) {
            mileage.append(INDICATOR_PER_MOVE);
        }
    }

    private static boolean isOkayToMove(int randomNumber) {
        return randomNumber >= MOVABLE_LOWER_BOUND;
    }


    public int getMileageAsInt() {
        return mileage.toString().length();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +
                " : " +
                mileage.toString();
    }
}

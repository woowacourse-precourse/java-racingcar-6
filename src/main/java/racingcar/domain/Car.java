package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int CRITICAL_OF_MOVING = 4;
    private final String name;
    private int distance;
    public static int maxDistance;

    private Car(String carName) {
        name = carName;
        distance = 0;
    }

    public static Car of(String carName) {
        if (carName.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    "자동차 이름은 " + MAX_LENGTH_OF_NAME + "글자 이하로 입력해주세요. (" + carName + " : " + carName.length() + "글자)");
        }
        return new Car(carName);
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveOrStay(int randomNumber) {
        if (randomNumber >= CRITICAL_OF_MOVING) {
            this.distance++;
            renewMaxDistance(this.distance);
        }
    }

    private void renewMaxDistance(int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
        }
    }

    public void printSticks() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}

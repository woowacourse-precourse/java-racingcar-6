package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public record Car(String carName) {
    private static final StringBuilder distanceTraveled = new StringBuilder();

    public static boolean isMovingForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static void moveForward() {
        distanceTraveled.append("-");
    }

    public String getDistanceTraveled() {
        return distanceTraveled.toString();
    }
}

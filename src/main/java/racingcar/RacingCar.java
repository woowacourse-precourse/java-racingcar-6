package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int forwardCount;

    public RacingCar(String name) {
        validateCarName(name);
        this.name = name;
        this.forwardCount = 0;
    }

    public void move() {
        if (canForward()) {
            forwardCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private boolean canForward() {
        int randNum = Randoms.pickNumberInRange(1, 9);
        return randNum >= 4;
    }

    private void validateCarName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("차량 이름은 1~5의 글자 수만 허용 됩니다.");
        }
    }

    private boolean isValidName(String name) {
        return name.isEmpty() || name.length() > 5;
    }
}

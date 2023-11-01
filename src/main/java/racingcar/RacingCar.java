package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    private int position;
    private final String carName;

    RacingCar(String carName) throws IllegalArgumentException {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야합니다.");
        }
        this.position = 0;
        this.carName = carName;
    }

    public void process() {
        tryForward(pickNumberInRange(0, 9));
    }

    public void tryForward(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        String progressLine = "-".repeat(Math.max(0, position));
        return carName + " : " + progressLine;
    }
}

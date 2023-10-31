package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Comparable<RacingCar> {
    public final String name;
    public int count = 0;

    public RacingCar(String carName) {
        validateCarName(carName);
        name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void execute() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            count++;
        }
    }

    @Override
    public int compareTo(RacingCar other) {
        return Integer.compare(this.count, other.count);
    }
}

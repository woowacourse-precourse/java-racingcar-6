package racingcar.Model;

import static org.mockito.Mockito.validateMockitoUsage;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int position = 0;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name2) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

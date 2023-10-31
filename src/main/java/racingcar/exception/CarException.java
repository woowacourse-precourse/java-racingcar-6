package racingcar.exception;

public class CarException {

    public void format(String carName) {
        nameLength(carName);
        allSpace(carName);
    }

    public void nameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다. error: " + carName);
        } else if (carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다. error: " + carName);
        }
    }

    public void allSpace(String carName) {
        boolean spaceCheck = true;
        for (int i = 0; i < carName.length(); i++) {
            if (carName.charAt(i) != ' ') {
                spaceCheck = false;
                break;
            }
        }

        if (spaceCheck) {
            throw new IllegalArgumentException("자동차 이름에 공백을 제외한 문자가 최소 1개이상 포함되어야 합니다. error: " + carName);
        }
    }

}

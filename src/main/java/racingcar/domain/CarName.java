package racingcar.domain;

import java.util.List;

public class CarName {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validateNameLength(carName);
        this.carName = carName;
    }

    private void validateNameLength(String carName) {
        if (!(carName.length() <= CAR_NAME_MAX_LENGTH && carName.length() >= CAR_NAME_MIN_LENGTH)) {
            throw new IllegalArgumentException("이름은 1~5자 길이로 입력해주세요.");
        }
    }

    public void writeOnWinnerList(List<String> winnerList) {
        winnerList.add(carName);
    }

    public String makeNameForPrintResult() {
        return carName + " : ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarName) {
            CarName temp = (CarName)obj;
            return carName.equals(temp.carName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }
}

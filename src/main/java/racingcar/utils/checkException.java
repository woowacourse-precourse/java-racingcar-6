package racingcar.utils;

public class checkException {

    // 자동차의 이름은 5자 이하 이어야 한다.
    public void checkCarNameException(String[] carNameArray) throws IllegalArgumentException {
        for (String carName : carNameArray) {

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하 이어야 한다.");
            }
        }
    }

    public void checkCommaCarName(String carName) throws IllegalArgumentException {
        if (!(carName.contains(","))) {
            throw new IllegalArgumentException("쉼표를 통해 구분해 주세요.");
        }
    }

    public void checkAskCount(String askCount) throws IllegalArgumentException {
        if (checkAskCountInteger(askCount) == false) {
            throw new IllegalArgumentException("시도 횟수를 다시 입력해 주세요.");
        }
    }

    public boolean checkAskCountInteger(String askCount) {
        try {
            Integer.parseInt(askCount);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

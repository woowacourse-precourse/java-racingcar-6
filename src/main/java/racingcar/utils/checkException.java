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
}

package racingcar;

public class Validation {
    /**
     * 입력된 차가 2대 이상인지 검증
     *
     * @param length
     */
    public static void carsMoreThanTwo(int length) {
        if (length < 2) {
            throw new IllegalArgumentException("2대 이상의 차를 입력해야 합니다.");
        }
    }

    /**
     * 차 이름이 5글자 이하인지 검증
     *
     * @param names
     */
    public static void isLongName(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다.");
            }
        }
    }


}

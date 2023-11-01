package racingcar.race;

public class CarNameExceptionProcessing {

    private static final String NAME_WARNING = "자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 1자 이상, 5자 이하만 가능합니다.";
    private static final String TWO_MORE_UNIT = "자동차 2대이상 입력해주셔야 합니다.";

    public static void checkName(String[] carNames) {

        checkComma(carNames);
        twoMoreUnitsCheck(carNames);
        for (String carName : carNames) {
            checkLength(carName);
            checkEmpty(carName);
            checkEquals(carName);
        }

    }

    public static void checkComma(String[] carName) {

        if (carName.length == 0) {
            throw new IllegalArgumentException(NAME_WARNING);

        }

    }

    public static void twoMoreUnitsCheck(String[] carName) {

        if (carName.length == 1) {
            throw new IllegalArgumentException(TWO_MORE_UNIT);

        }

    }

    public static void checkLength(String carName) {

        if (carName.length() > 5) {
            throw new IllegalArgumentException(NAME_WARNING);
        }

    }

    public static void checkEmpty(String carName) {

        if (carName.isEmpty()) {
            throw new IllegalArgumentException(NAME_WARNING);
        }

    }

    public static void checkEquals(String carName) {

        if (" ".equals(carName)) {
            throw new IllegalArgumentException(NAME_WARNING);
        }
    }

}

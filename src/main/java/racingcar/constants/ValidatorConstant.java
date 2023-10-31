package racingcar.constants;

public class ValidatorConstant {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String carNameErrorMessage = "적절하지 않은 자동차 이름을 입력했습니다.";
    public static final String TotalRoundErrorMessage = "적절하지 않은 라운드를 입력했습니다.";

    private ValidatorConstant() {
        throw new AssertionError();
    }
}

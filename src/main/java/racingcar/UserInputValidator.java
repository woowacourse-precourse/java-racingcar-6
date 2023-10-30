package racingcar;

public class UserInputValidator {

    private static final String REGEXP_ONLY_NUM = "^[1-9][0-9]*$";

    private static final String SPACE = "\\s";

    public static final Integer ALLOW_CAR_LENGTH = 5;

    public static boolean carNameIsValid(String carName) {
        String[] carNames = carName.replaceAll(SPACE, "").split(",");
        for (String name : carNames) {

            if (name.length() > ALLOW_CAR_LENGTH) {
                throw new IllegalArgumentException("자동차 이름 " + name + "은 허용 길이 " + ALLOW_CAR_LENGTH + "글자를 넘었습니다");
            }
        }
        return true;
    }


    public static boolean attemptCountIsValid(String attempt) {

        if (!attempt.matches(REGEXP_ONLY_NUM)) {
            throw new IllegalArgumentException("횟수는 숫자로만 입력해주세요");
        }
        return true;
    }
}
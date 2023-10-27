package racingcar;

public class UserInputValidator {
    final String REGEXP_ONLY_NUM = "^[1-9][0-9]*$";

    public boolean carNameIsValid(String carName) {

        String[] carNames = carName.replaceAll("\\s", "")
                .split(",");

        for (String name : carNames) {

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름" + name + "은 허용 길이를 넘었습니다");
            }
        }
        return true;
    }


    public boolean attemptCountIsValid(String attempt) {

        if (!attempt.matches(REGEXP_ONLY_NUM)) {
            throw new IllegalArgumentException("횟수는 숫자로만 입력해주세요");
        }
        return true;
    }
}
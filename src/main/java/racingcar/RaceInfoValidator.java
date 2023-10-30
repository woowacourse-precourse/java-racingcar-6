package racingcar;

public class RaceInfoValidator {


    public static void checkCarNameLength(String[] input) throws IllegalArgumentException {
        for (String str : input) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력 - 자동차 이름은 5글자 이하만 가능");
            }
        }

    }

    public static void hasMultipleCarNames(String[] input) throws IllegalArgumentException {
        if (input.length <= 1) {
            throw new IllegalArgumentException("잘못된 입력 - 자동차 이름을 2개 이상 입력해주세요");
        }
    }

    public static void checkAttemptCount(String input) throws IllegalArgumentException {
        // 얘네 함수 나눌지
        // 얘네 같은 try문에다가 넣을지
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 - 시도횟수는 자연수를 입력헤주세요.");
        }

        // getNumericValue, valueOf 사용해보기?
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("잘못된 입력 - 시도횟수는 1 이상의 값을 입력해주세요. (2)");
        }
    }
}

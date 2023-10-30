package racingcar;

public class Constant {
    public static class InputMenu {
        public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        public static final String COMMA = ",";
        public static final String BLANK = ",";
        public static final Integer CAR_NAME_MAXIMUM_LENGTH = 4;
        public static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";
        public static final String EXCEPTION_INVALID_CAR_NAME = "자동차 이름은 5글자 이하로 작성해주세요.";
        public static final String EXCEPTION_INVALID_INTEGER = "숫자를 입력해주세요.";
        public static final String EXCEPTION_INVALID_INTEGER_ZERO = "0 이외의 숫자를 입력해주세요";

    }

    public static class RacingMenu {
        public static final String PLUS_SCORE = "-";
    }

    public static class OutputMenu {
        public static final String OUTPUT_RESULT = "실행 결과";
        public static final String COLON = " : ";
        public static final String FINAL_WINNER = "최종 우승자 : ";
        public static final String COMMA_AND_SPACE = ", ";
    }
}

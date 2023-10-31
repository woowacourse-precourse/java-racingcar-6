package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NOT_PERMIT_BLANK = "공백은 허용하지 않습니다.";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PERMIT_ONLY_NUMBER = "입력값은 오직 숫자만 허용합니다.";
    private static final String PERMIT_START_INCLUSIVE_ONE = "입력값은 1 이상부터 허용합니다.";
    private static final int LEAST_NUMBER_OVER = 1;

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return validInputBlank(Console.readLine());
    }

    private String validInputBlank(String input) {
        if ((input.isEmpty() || input.contains(" "))) {
            throw new IllegalArgumentException(NOT_PERMIT_BLANK);
        }
        return input;
    }

    public Integer inputHowManyTry() {
        System.out.println(HOW_MANY_TRY_MESSAGE);
        return validInputType(Console.readLine());
    }

    // 1이상의 정수값만 허용합니다.
    private Integer validInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PERMIT_ONLY_NUMBER, e);
        }

        if (LEAST_NUMBER_OVER > input.charAt(0)) {
            throw new IllegalArgumentException(PERMIT_START_INCLUSIVE_ONE);
        }
        return Integer.parseInt(input);
    }
}

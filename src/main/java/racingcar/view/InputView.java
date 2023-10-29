package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private final static String GET_CAR_NAMES_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String GET_TRIAL_NUMBER_SENTENCE = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        System.out.println(GET_CAR_NAMES_SENTENCE);
        String input = bringUserInput();
        return input;
    }


    public String inputTrialNumber() {
        System.out.println(GET_TRIAL_NUMBER_SENTENCE);
        String input = bringUserInput();
        return input;
    }


    private String bringUserInput() throws IllegalStateException {
        String input = Console.readLine();
        if (isInputNull(input)) {
            throw new IllegalStateException();
        }
        return input;
    }

    private boolean isInputNull(String userInput) {
        return userInput == null;
    }
}

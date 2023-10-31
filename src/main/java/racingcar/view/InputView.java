package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Information;
import racingcar.util.ExceptionMessages;

public class InputView {
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIMES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
    public Information getInformation(){
        return Information.of(getInput(NAME_MESSAGE), getInput(TIMES_MESSAGE));
    }

    private String getInput(String messeage){
        System.out.println(messeage);
        return validateInput(Console.readLine());
    }

    public String validateInput(String input) {
        if(! checkNullString(input)&&checkEmpty(input) ) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_NULL_EXCEPTION);
        }
        return input;
    }

    private boolean checkEmpty(String input) {
        return input.isEmpty();
    }

    private boolean checkNullString(String input) {
        return input == null;
    }

}

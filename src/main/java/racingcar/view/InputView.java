package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vaildator.InputValidator;

import javax.xml.validation.Validator;

import static racingcar.Constant.EXCEPTION_MESSAGE;

public class InputView {

    private final static String CARS_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String READ_ROUND = "시도할 회수는 몇회인가요?";
    private final static String NUMBER_OF_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String start(){
        System.out.println(CARS_NAMES_INPUT_MESSAGE);

        String input = Console.readLine();

        if(InputValidator.isBlankInput(input)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        return input;
    }







}

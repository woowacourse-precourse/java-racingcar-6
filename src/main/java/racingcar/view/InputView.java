package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.vaildator.InputValidator.*;

public class InputView {

    private final static String CARS_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String READ_ROUND = "시도할 회수는 몇회인가요?";

    public String start(){
        System.out.println(CARS_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();
        validateNotBlankInput(input);
        return input;
    }


    public int readRound(){
        System.out.println(READ_ROUND);
        String input = Console.readLine();
        validateNotBlankInput(input);
        int round = validateNotNumericNumber(input);
        validatePositiveNumber(round);
        System.out.println();
        return round;
    }





}

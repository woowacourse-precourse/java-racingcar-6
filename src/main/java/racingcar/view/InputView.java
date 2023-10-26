package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CARS_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SEPARATOR = ",";
    public List<String> readCarNames(){
        System.out.println(CARS_NAME_INPUT_MESSAGE);
        String input  = Console.readLine();
        return Arrays.asList(input.split(SEPARATOR));
    }
}

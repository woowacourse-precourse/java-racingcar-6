package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> getCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String rawString = Console.readLine();

        return parseString(rawString);
    }

    private static List<String> parseString(String rawString) {
        return new ArrayList<>(Arrays.asList(rawString.split(",")));
    }

}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Parser;
import racingcar.vo.TryTime;

import java.util.List;

public class InputMessage {

    public static final String CAR_NAME_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_REQUEST = "시도할 회수는 몇회인가요?";

    public static List<String> printCarNameInputMessage() {
        System.out.println(CAR_NAME_REQUEST);
        String input = Console.readLine();
        return Parser.parseCarNameInput(input);
    }

    public static TryTime printTryTimesInputMessage() {
        System.out.println(TRY_COUNT_REQUEST);
        int time = Parser.parseTryTimesInput(Console.readLine());
        return new TryTime(time);
    }
}

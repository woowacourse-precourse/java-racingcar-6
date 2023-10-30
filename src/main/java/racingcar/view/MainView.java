package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.Convert;

public class MainView {
    private static final String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static void printStartMessage() {
        System.out.println(startMessage);
    }


    public static List<String> getCarNames() {
        String carNames = Console.readLine();
        return Convert.stringToListByComma(carNames);
    }
}

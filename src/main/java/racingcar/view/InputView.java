package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.Utils.splitString;

import java.util.List;

public class InputView {
    public static List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return splitString(readLine());
    }

    public static String askHowManyRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }
}

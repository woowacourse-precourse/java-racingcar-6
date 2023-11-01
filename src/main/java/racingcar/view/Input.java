package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Mapper.changeToListString(Console.readLine());
    }

    public static int inputMoveChance() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Mapper.changeToInteger(Console.readLine());
    }

}

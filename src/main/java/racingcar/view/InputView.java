package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Utils;

import java.util.List;

public class InputView {
    private final Utils utils;

    public InputView() {
        utils = new Utils();
    }

    public List<String> insertCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String names = Console.readLine();
        return utils.convertStringToList(names);
    }

    public int insertTryTimes() {
        System.out.println("시도할 회수는 몇회인가요?\n");
        String tryNumber = Console.readLine();
        return utils.convertStringToNumber(tryNumber);
    }

}

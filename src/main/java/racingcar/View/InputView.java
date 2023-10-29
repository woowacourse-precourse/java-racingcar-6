package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final String MSG_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_COUNT = "시도할 회수는 몇회인가요?";

    public List<String> inputCarNames(){
        System.out.println(MSG_NAME);
        List<String> carNameList = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        return carNameList;
    }
    public String inputCounts(){
        System.out.println(MSG_COUNT);
        return Console.readLine();
    }
}

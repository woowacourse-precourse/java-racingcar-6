package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> inputNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String names = Console.readLine();
        List<String> nameList = Arrays.stream(names
                        .split(","))
                        .toList();


        return nameList;
    }
}

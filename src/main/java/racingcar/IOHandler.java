package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOHandler {

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carNames = List.of(Console.readLine().split(","));
        // TODO: validateCarNames(carNames);

        return carNames;
    }

}

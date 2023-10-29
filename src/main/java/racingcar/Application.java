package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public void informInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

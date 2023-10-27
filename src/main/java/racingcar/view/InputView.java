package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String getUserCarNames() {
        return Console.readLine();
    }

    public List<String> parseCarNames(String userInput) {
        return Arrays.stream(userInput.replace(" ", "").split(","))
                .collect(Collectors.toList());
    }
}

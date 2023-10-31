package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = carNames();
//        System.out.println(carNames);
    }


    private static List<String> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        HashMap<String, Integer> namesMap = InputValidator.validateInput(input);
        return new ArrayList<>(namesMap.keySet());
    }

}



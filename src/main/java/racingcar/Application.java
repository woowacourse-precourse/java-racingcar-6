package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNamesList = inputCarNames();
        System.out.println(carNamesList);
    }

    public static List<String> inputCarNames() {
        // 문자열 받아서 콤마(,)롤 기준으로 나누어 List에 담음
        String carNames = Console.readLine();
        String[] carNamesSplitted = carNames.split(",");
        List<String> carNamesList = new ArrayList<>();
        Collections.addAll(carNamesList, carNamesSplitted);
        return carNamesList;
    }
}

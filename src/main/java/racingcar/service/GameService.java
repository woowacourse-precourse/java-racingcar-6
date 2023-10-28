package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> carList = new ArrayList<>();
        for (String s : carNames.split(",")) {
            if (s.contains(" ") || s.length() > 5 || carList.contains(s)) {
                throw new IllegalArgumentException();
            }
            carList.add(s);
        }
    }
}

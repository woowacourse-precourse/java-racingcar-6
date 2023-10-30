package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Screen {
    static public String[] inputRaceInformation() {
        String[] names = inputCarNames();
        return names;
    }

    static public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return names.split(",");
    }

}

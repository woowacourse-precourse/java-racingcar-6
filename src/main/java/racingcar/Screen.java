package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Screen {
    static public String[] inputRaceInformation() {
        String[] names = askCarNames();
        return names;
    }

    static public String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        for (String name : names) {
            checkValidName(name);
        }
        return names;
    }

    static private void checkValidName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw (new IllegalArgumentException("Invalid Argument"));
        }
    }
}

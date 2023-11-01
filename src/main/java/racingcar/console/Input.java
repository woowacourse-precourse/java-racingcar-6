package racingcar.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return carNames;
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void validateCarNames(String names) {
        for (String name : names.split(",")) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}


package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        // 각 이름의 유효성 검사
        for (String name : names) {
            validateName(name);
        }

        return names;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static int getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
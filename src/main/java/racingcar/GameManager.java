package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    public static String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine().replaceAll(" ", "");

        String[] names = input.split(",");
        validate(names);

        return names;
    }

    public static void validate(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        for (String name : names) {
            if (name.equals("")) {
                throw new IllegalArgumentException("이름을 입력해주세요.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int count = 0;

        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        return count;
    }
}

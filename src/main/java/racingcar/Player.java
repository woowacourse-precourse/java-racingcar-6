package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    private Player() {
    }

    public static List<String> inputCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = List.of(Console.readLine().split(","));
        validateListSize(names.size());

        names.forEach(Player::validateName);
        names.forEach(System.out::println);

        return names;
    }

    public static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputString = Console.readLine();

        int count = Integer.parseInt(inputString);
        validateCount(count);

        return count;
    }

    private static void validateListSize(int size) {
        if (size > 3) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    private static void validateCount(int count) {
        if (count <= 0 || count > 9) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}



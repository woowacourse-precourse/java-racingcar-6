package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Player {

    private static Player player;

    private Player() {
    }

    public static Player getInstance() {
        if (player == null) {
            return new Player();
        }
        return player;
    }

    public List<String> inputCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> car = Arrays.stream(Console.readLine().split(",")).toList();

        validateListSize(car.size());
        car.forEach(Player::validateName);

        return car;
    }

    public int inputCount() {
        int count = 0;

        System.out.println("시도할 회수는 몇회인가요?");
        String inputString = Console.readLine();

        count = Integer.parseInt(inputString);
        validateCount(count);

        return count;
    }

    private static void validateListSize(int listSize) {
        if (listSize > 3) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    private static void validateName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    private static void validateCount(int count) {
        if (count <= 0 || count > 9) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}
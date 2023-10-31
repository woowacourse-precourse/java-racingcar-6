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
            return player = new Player();
        }
        return player;
    }

    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> car = Arrays.stream(Console.readLine().split(",")).toList();

        player.validateListSize(car.size());
        car.forEach(player::validateName);

        return car;
    }

    public int inputCount() {
        int count = 0;

        System.out.println("시도할 회수는 몇회인가요?");
        String inputString = Console.readLine();

        count = Integer.parseInt(inputString);
        player.validateCount(count);

        return count;
    }

    // 차량이름을 3대 이상 적을 시 예외
    private void validateListSize(int listSize) {
        if (listSize > 3) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    //공백 or 5자 초과 시 예외
    private void validateName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    //실행 횟수 1미만 9초과 시 예외
    private void validateCount(int count) {
        if (count < 1 || count > 9) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}
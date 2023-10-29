package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class GameShell {
    public void startGame() {

    }

    public List<Car> askCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        return Stream.of(carNames)
                .map(Car::from)
                .toList();
    }

    public int askRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력값이 숫자형식이 아닙니다.");
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력가능한 범위를 벗어났습니다.");
        }
    }

    public void exitGame() {
        Console.close();
    }
}

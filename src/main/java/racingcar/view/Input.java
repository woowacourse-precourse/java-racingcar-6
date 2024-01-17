package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {
    public Input() {
    }

    public String promptForCarNames() {
        String cars;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            cars = Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        return cars;
    }

    public String promptForAttempts() {
        String move;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            move = Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException("시도할 횟수를 입력하세요");
        }

        return move;
    }
}

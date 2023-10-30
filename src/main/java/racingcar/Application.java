package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            validateCarName(carName);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        int count = Integer.parseInt(input);

        new RacingGame(count);
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}

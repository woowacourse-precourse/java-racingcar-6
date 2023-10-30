package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public static void play() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        int count;
        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }

        Race race = new Race(carNames, count);
        race.start();
    }
}

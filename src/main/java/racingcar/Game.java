package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Integer attemptsNumber = 5;

    public void start() {
        while (0 < attemptsNumber) {
            Console.readLine();
            attemptsNumber--;
        }
    }

    public void userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        String userInputCarNameString = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");

        Integer attemptsNumber = Integer.valueOf(Console.readLine());
    }

    public void printResult() {
        System.out.println('실행 결과');

    }
}

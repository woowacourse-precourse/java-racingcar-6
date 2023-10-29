package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(Console.readLine());

        run();
    }

    private void run() {
        // TODO: Car 생성

        System.out.println("\n실행 결과");

        // TODO: Car 경주 실행

        exist();
    }

    private void exist() {
        System.out.print("최종 우승자 : ");
    }
}

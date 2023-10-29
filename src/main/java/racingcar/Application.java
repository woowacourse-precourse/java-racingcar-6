package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int attemptNumber = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 자동차 이름 받아서 쉼표 기준으로 나누고 리스트에 저장(static으로 할 지 말 지 고민되네에베네)
        CarManager newCarList = new CarManger();
        newCarList.createCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        // 시도 횟수 받아서 시도할 회수에 저장
        attemptNumber = getAttemptNumber();

        while (attemptNumber) {
            Referee.nthAttemptRace();
        }

        final String winner = Referee.winnerJudgment();
        printWinner();
    }

    private static void printWinner() {
    }

    private static int getAttemptNumber() {
        return Integer.valueOf(Console.readLine());
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int attemptNumber = 0;

    public static void main(String[] args) {
        CarRaceManager newRaceManager = new CarRaceManager();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        newRaceManager.createCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        attemptNumber = getAttemptNumber();

        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < attemptNumber; i++) {
            newRaceManager.nthAttemptRace();
            newRaceManager.printAttemptResult();
        }

        newRaceManager.winnerJudgment();
        newRaceManager.printWinner();
        Console.close();
    }

    private static int getAttemptNumber() {
        String attemptNumber =Console.readLine().replaceAll(" ","");
        Validation.validateAttemptNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }
}

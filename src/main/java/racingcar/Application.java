package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        racingGame();

    }

    private static void racingGame () {
        String carNames = inputCarNames();
        int trialTimes = inputTrialTimes();


    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    private static int inputTrialTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }


}

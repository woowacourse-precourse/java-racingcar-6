package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    private Setting setting = new Setting();

    public void setUp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        setting.initializeCars(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        String round = Console.readLine();
        setting.initializeRound(round);
    }


}

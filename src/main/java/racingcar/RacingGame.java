package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingGame {

    private Setting setting = new Setting();

    public void run() {
        setUp();
        race();
        announceWinner();
    }

    private void setUp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        setting.initializeCars(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        String round = Console.readLine();
        setting.initializeRound(round);
    }

    private void race() {
        System.out.println("실행 결과");

        for (int currentRound = 1; currentRound <= setting.getRound(); currentRound++) {
            setting.tryCarsForward();
            List<String> racingState = Commentator.getRacingState(setting);
            printRacingState(racingState);
            System.out.println();
        }
    }

    private void announceWinner() {
        List<String> winnerList = Commentator.getWinners(setting);
        String winners = String.join(", ", winnerList);
        System.out.print("최종 우승자 : " + winners);
    }

    private void printRacingState(List<String> racingState) {
        for (String carState : racingState) {
            System.out.println(carState);
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingApp {

    private int executeCount;

    private RacingCarList racingCarList;

    public void run() {
        String input = getPlayerList();
        this.racingCarList = new RacingCarList(input);
        getExecuteCount();
        play();
        printRacingResult();
    }

    private void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < executeCount; i++) {
            racingCarList.executeOneStep();
            racingCarList.printRacingCarsCurrentStatus();
        }
    }

    private void printRacingResult() {
        int maxForward = racingCarList.getMaxForward();
        List<String> winnerList = racingCarList.getWinnerList(maxForward);
        System.out.print("최종 우승자 : " + String.join(", ", winnerList));
    }

    private void getExecuteCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateExecuteCount(input);
        System.out.println("\n");
    }

    private void validateExecuteCount(String input) {
        try {
            this.executeCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        throwExceptionIfCountLessThanZero();
    }

    private void throwExceptionIfCountLessThanZero() {
        if (this.executeCount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private String getPlayerList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

}

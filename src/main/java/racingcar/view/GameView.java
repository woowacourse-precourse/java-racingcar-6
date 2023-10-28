package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameView {

    private static final String NAME_DELIMITER = ", ";

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = getUserInput();

        return carNames;
    }

    public String inputAttempts() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String attempts = getUserInput();

        return attempts;
    }

    public void showRaceResult() {
        System.out.println("\n실행 결과");
    }

    public void showCarStatus(List<String> carStatusList) {
        for (String status : carStatusList) {
            System.out.println(status);
        }
        System.out.print("\n");
    }

    public void showWinnerList(List<String> winnerList) {
        String winners = String.join(NAME_DELIMITER, winnerList);
        System.out.println("최종 우승자 : " + winners);
    }

    private String getUserInput() {
        return Console.readLine();
    }
}

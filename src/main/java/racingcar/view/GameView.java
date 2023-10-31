package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Player;
import racingcar.utility.InputDataExceptionHandler;

public class GameView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(playerCarNames.split(","))
                .stream()
                .map(it -> it.trim())
                .toList();

        InputDataExceptionHandler.validateCarNames(carNames);

        return carNames;
    }

    public int getTotalRounds() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String totalRounds = Console.readLine();

        InputDataExceptionHandler.validateTotalRounds(totalRounds);

        return Integer.parseInt(totalRounds);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void nowRoundResultPrint(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player);
        }
        System.out.println();
    }

    public void finalResultPrint(List<String> finalWinner) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", finalWinner));
    }
}

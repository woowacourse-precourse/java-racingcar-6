package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Player;

public class RacingCarGameView {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String GAME_WINNER = "최종 우승자 : ";

    public String requestCarName() {
        System.out.println(REQUEST_CAR_NAME);
        return Console.readLine();
    }

    public int requestTryNumber() {
        System.out.println(REQUEST_TRY_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public void gameResult() {
        System.out.print(GAME_RESULT);
    }

    public void showNowPlayerLocation(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.print(player.getName() + " : ");
            for (int i = 0; i < player.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void showGameWinner(List<Player> winner) {
        StringBuilder gameWinner = new StringBuilder();
        boolean first = true;

        for (Player player : winner) {
            if (!first) {
                gameWinner.append(", ");
            }
            gameWinner.append(player.getName());
            first = false;
        }

        System.out.print(GAME_WINNER + gameWinner);

    }
}

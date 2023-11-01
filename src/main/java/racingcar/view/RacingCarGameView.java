package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Player;

public class RacingCarGameView {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String GAME_WINNER = "최종 우승자 : ";

    public List<String> requestCarName() {
        System.out.println(REQUEST_CAR_NAME);
        List<String> carNames = Arrays.asList(Console.readLine().split(","));

        for (String name : carNames) {
            validName(name);
        }

        return carNames;
    }

    public int requestTryNumber() {
        System.out.println(REQUEST_TRY_NUMBER);
        int tryNum = Integer.parseInt(Console.readLine());
        System.out.println();

        return tryNum;
    }

    public void gameResult() {
        System.out.println(GAME_RESULT);
    }

    public void showNowPlayerLocation(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.print(player.getName() + " : ");
            showLocation(player.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    public void showGameWinner(List<Player> winner) {
        System.out.println(GAME_WINNER + String.join(", ", winner.stream().map(Player::getName).toList()));
    }

    public void validName(String name) {
        if (name.length() > 4) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void showLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }
}

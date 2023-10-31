package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SEPARATOR = ",";
    public static final String PLAYER_NAME_ERROR = "플레이어의 이름은 5글자 이하이어야 합니다.";
    public static final String PLAYER_EMPTY_ERROR = "한명 이상의 플레이어를 입력해야합니다.";
    public static final String GAME_COUNT_ERROR = "게임 횟수는 1이상의 정수이어야합니다.";


    public List<String> inputPlayerList() {
        String inputString = Console.readLine();
        validateEmpty(inputString);

        List<String> playerList = Arrays.stream(inputString.split(SEPARATOR))
                .toList();

        validatePlayer(playerList);
        return playerList;
    }

    public int inputGameCount() {
        String inputString = Console.readLine();
        validateNumber(inputString);

        int gameCount = Integer.parseInt(inputString);
        validateGameCount(gameCount);

        return gameCount;
    }

    private void validateEmpty(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(PLAYER_EMPTY_ERROR);
        }
    }

    private void validatePlayer(List<String> playerList) {
        for (String player : playerList) {
            if (player.length() > 5) {
                throw new IllegalArgumentException(PLAYER_NAME_ERROR);
            }
        }
    }

    private void validateNumber(String inputString) {
        if (!inputString.matches("[0-9]+")) {
            throw new IllegalArgumentException(GAME_COUNT_ERROR);
        }
    }

    private void validateGameCount(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException(GAME_COUNT_ERROR);
        }
    }
}

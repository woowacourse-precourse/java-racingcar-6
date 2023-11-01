package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    private static final String INPUT_PLAYER_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SPLIT_SEPARATING = ",";
    private static final int VALIDATE_MAX_NUMBER = 5;

    private static final String VALIDATE_NAME_EXCEPTION_PRINT = "플레이어의 이름은 5자 이하만 가능합니다.";
    private static final String INPUT_ROUND_PRINT = "시도할 회수는 몇회인가요?";
    private int round;
    private ArrayList<String> player;

    public void inputPlayer() {
        System.out.println(INPUT_PLAYER_PRINT);
        String stringPlayer = Console.readLine();
        setPlayerName(stringPlayer);
    }

    public void setPlayerName(String stringPlayer) {
        player = new ArrayList<>(Arrays.asList(stringPlayer.split(SPLIT_SEPARATING)));
        for (String playerName :
                player) {
            validateName(playerName);
        }
    }

    public ArrayList<String> getPlayerName() {
        return player;
    }

    public void validateName(String playerName) {
        if (playerName.length() > VALIDATE_MAX_NUMBER || playerName.equals("")) {
            throw new IllegalArgumentException(VALIDATE_NAME_EXCEPTION_PRINT);
        }

    }

    public void inputRound() {
        System.out.println(INPUT_ROUND_PRINT);
        int intRound = Integer.parseInt(Console.readLine());
        setRound(intRound);
    }

    public void setRound(int intRound) {
        round = intRound;
    }

    public int getRound() {
        return round;
    }

}

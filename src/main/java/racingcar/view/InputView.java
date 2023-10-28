package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LENGTH_ERROR = "이름은 5자 이하만 가능합니다.";
    private static final String IS_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String IS_NOT_NATURAL_NUMBER = "전진횟수는 자연수여야 합니다.";
    private static final Character ZERO = '0';
    private static final Character NINE = '9';
    public String[] inputPlayers() {
        String players = Console.readLine();
        return splitCommaAndValidate(players);
    }

    private void validate(String[] players) {
        nameLengthValidation(players);
    }

    private String[] splitCommaAndValidate(String players) {
        String[] separatedPlayers = players.split(",");
        validate(separatedPlayers);
        return separatedPlayers;
    }

    private void nameLengthValidation(String[] players) {
        for (String player : players) {
            if (player.length() > 5) {
                throw new IllegalArgumentException(LENGTHERROR);
            }
        }
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LENGTHERROR = "이름은 5자 이하만 가능합니다.";
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

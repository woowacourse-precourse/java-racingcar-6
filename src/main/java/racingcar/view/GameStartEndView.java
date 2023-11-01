package racingcar.view;

import racingcar.dto.WinnerCarDto;

import static racingcar.constants.GameMessage.ATTEMPT_COUNT_MESSAGE;
import static racingcar.constants.GameMessage.CAR_NAME_MESSAGE;


public class GameStartEndView {

    private static final String WINNING_CAR_NAMES_MESSAGE_FORMAT = "최종 우승자 : %s";

    public void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE.getMessage());
    }

    public void printAttemptCountMessage() {
        System.out.println(ATTEMPT_COUNT_MESSAGE.getMessage());
    }

    public void printWinningCarNames(WinnerCarDto winnerCarDTO) {
        System.out.print(String.format(WINNING_CAR_NAMES_MESSAGE_FORMAT, winnerCarDTO.winnerCarNames()));
    }

}

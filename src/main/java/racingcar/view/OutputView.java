package racingcar.view;

import static racingcar.model.constants.Phrase.GAME_RESULT;
import static racingcar.model.constants.Phrase.GAME_WINNER;

import racingcar.model.dto.CarResponseDto;
import racingcar.model.dto.GameResponseDto;

public class OutputView {
    public static void printGameResult() {
        System.out.println(GAME_RESULT.getMessage());
    }

    public static void printGameScore(GameResponseDto gameResponseDto) {
        System.out.println(gameResponseDto.getGameResult());
    }

    public static void printJumpLine() {
        System.out.println();
    }

    public static void printWinner(CarResponseDto carResponse) {
        System.out.println(GAME_WINNER.getMessage() + carResponse.getWinnerCarNames());
    }
}

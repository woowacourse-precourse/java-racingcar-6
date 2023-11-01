package racingcar.util;

import static racingcar.constant.ConsoleOutputConstants.FINAL_WINNER;
import static racingcar.constant.RacingGameConstants.PROGRESS_MESSAGE_FORMAT;

import racingcar.domain.Car;
import racingcar.dto.FinalResult;

public class ProgressMessageGenerator {

    public static String generateProgressStateMessage(Car car) {
        return PROGRESS_MESSAGE_FORMAT.formatted(car.getName(), car.getDash());
    }

    public static String generateFinalResultMessage(FinalResult finalResult) {
        return FINAL_WINNER + finalResult.getNameString();
    }

}

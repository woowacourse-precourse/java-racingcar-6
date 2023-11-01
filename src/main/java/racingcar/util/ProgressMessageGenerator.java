package racingcar.util;

import static racingcar.constant.ConsoleOutputConstants.FINAL_WINNER;

import racingcar.domain.Car;
import racingcar.domain.dto.FinalResult;

public class ProgressMessageGenerator {

    public static String generateProgressStateMessage(Car car) {
        String messageFormat = "%s : %s";
        return messageFormat.formatted(car.getName(), car.getDash());
    }

    public static String generateFinalResultMessage(FinalResult finalResult) {
        return FINAL_WINNER + finalResult.getNameString();
    }

}

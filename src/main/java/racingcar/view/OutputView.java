package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.CarController;
import racingcar.message.ConsoleMessage;
import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.util.StringConstants;

public class OutputView {
    public void printStartMessage() {
        System.out.println(ConsoleMessage.OUT_RESULT.getMessage());
    }

    public void printCarStatus(CarDto dto) {
        String positionIndicator = StringConstants.DASH.getValue().repeat(dto.getPosition());
        System.out.println(dto.getName() + StringConstants.COLON_WITH_SPACE.getValue() + positionIndicator);
    }

    public void printWinners(List<String> winners) {
        String result = String.join(StringConstants.COMMA.getValue() + " ", winners);
        System.out.println(ConsoleMessage.OUTPUT_WINNER.getMessage() +" "+ result);
    }
}

package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.enums.OutputMessage.COLON;
import static racingcar.enums.OutputMessage.DASH;
import static racingcar.enums.OutputMessage.JOIN_DELIMITER;
import static racingcar.enums.OutputMessage.NEW_LINE;
import static racingcar.enums.OutputMessage.RESULT_MESSAGE;
import static racingcar.enums.OutputMessage.WINNER_MESSAGE;

public class OutputView {
    private StringBuilder stringBuilder;

    public void showResult() {
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void showPosition(Cars cars) {
        List<Car> carList = cars.getCars();
        stringBuilder = new StringBuilder();

        for (Car car : carList) {
            stringBuilder.append(car.getName())
                    .append(COLON.getMessage())
                    .append(makeDelimiter(car.getPosition()))
                    .append(NEW_LINE.getMessage());
        }
        stringBuilder.append(NEW_LINE.getMessage());

        System.out.print(stringBuilder);
    }

    private String makeDelimiter(int position) {
        return DASH.getMessage().repeat(position);
    }

    public void showWinner(List<String> winner) {
        stringBuilder = new StringBuilder(WINNER_MESSAGE.getMessage());
        stringBuilder.append(String.join(JOIN_DELIMITER.getMessage(), winner));

        System.out.print(stringBuilder);
    }
}

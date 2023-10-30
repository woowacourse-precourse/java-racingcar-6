package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.constant.StringConstant.COLON;
import static racingcar.constant.StringConstant.DASH;
import static racingcar.constant.StringConstant.JOIN_DELIMITER;
import static racingcar.constant.StringConstant.NEW_LINE;
import static racingcar.constant.StringConstant.RESULT_MESSAGE;
import static racingcar.constant.StringConstant.WINNER_MESSAGE;

public class OutputView {
    private StringBuilder stringBuilder;

    public void showResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showPosition(Cars cars) {
        List<Car> carList = cars.getCars();
        stringBuilder = new StringBuilder();

        for (Car car : carList) {
            stringBuilder.append(car.getName())
                    .append(COLON)
                    .append(makeDelimiter(car.getPosition()))
                    .append(NEW_LINE);
        }
        stringBuilder.append(NEW_LINE);

        System.out.print(stringBuilder);
    }

    private String makeDelimiter(int position) {
        return DASH.repeat(position);
    }

    public void showWinner(List<String> winner) {
        stringBuilder = new StringBuilder(WINNER_MESSAGE);
        stringBuilder.append(String.join(JOIN_DELIMITER, winner));

        System.out.print(stringBuilder);
    }
}

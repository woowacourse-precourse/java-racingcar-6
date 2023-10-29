package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static racingcar.constant.StringConstant.COLON;
import static racingcar.constant.StringConstant.DASH;
import static racingcar.constant.StringConstant.JOIN_DELIMITER;
import static racingcar.constant.StringConstant.RESULT_MESSAGE;
import static racingcar.constant.StringConstant.WINNER_MESSAGE;

public class OutputView {
    public void showResult() {
        System.out.println(RESULT_MESSAGE);
    }
    public void showPosition(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.getName() + COLON + makeDelimiter(car.getPosition()));
        }
        System.out.println();
    }

    private String makeDelimiter(int position) {
        return DASH.repeat(position);
    }

    public void showWinner(List<String> winner) {
        String winnerName = String.join(JOIN_DELIMITER, winner);
        System.out.print(WINNER_MESSAGE + winnerName);
    }
}

package racingcar.view;

import static racingcar.constant.Constants.NAME_INPUT_MESSAGE;
import static racingcar.constant.Constants.ROUND_NUMBER_INPUT_MESSAGE;
import static racingcar.constant.Constants.SCORE;
import static racingcar.constant.Constants.SEPARATE_NAME_TO_SCORE;
import static racingcar.constant.Constants.START_ROUND_MESSAGE;
import static racingcar.constant.Constants.WINNER_MESSAGE_START;
import static racingcar.constant.Constants.WINNER_SEPARATOR;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getCarName());
            stringBuilder.append(SEPARATE_NAME_TO_SCORE);
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append(SCORE);
            }
            System.out.println(stringBuilder.toString());
        });
        System.out.println();
    }

    public void printGameResult(List<Car> winnerList) {
        List<String> winnerNames = winnerList.stream().map(Car::getCarName).toList();
        System.out.print(WINNER_MESSAGE_START);
        System.out.println(String.join(WINNER_SEPARATOR, winnerNames));
    }

    public void printCarNamesInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    public void printRoundNumberInputMessage() {
        System.out.println(ROUND_NUMBER_INPUT_MESSAGE);
    }

    public void printStartRoundMessage() {
        System.out.println(START_ROUND_MESSAGE);
    }
}

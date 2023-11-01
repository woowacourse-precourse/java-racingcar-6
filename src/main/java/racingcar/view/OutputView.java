package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.IntegerConstant;
import racingcar.domain.Position;
import racingcar.service.Referee;

public class OutputView {

    private static final String CAR_POSITION = "-";
    private static final String DELIMITER = " : ";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String RESULT = "실행 결과";

    public void showResultMessage() {
        System.out.println();
        System.out.println(RESULT);
    }

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println(car.getCarName() + DELIMITER + countPositionToString(stringBuilder, car.getPosition()));
        }
        System.out.println();
    }

    public StringBuilder countPositionToString(StringBuilder stringBuilder, Position position) {
        return stringBuilder.append(
                CAR_POSITION.repeat(
                        Math.max(IntegerConstant.MIN_VALUE.getValue(), position.getCarPosition())));
    }

    public void showWinner(Referee referee, Cars generatedCars) {
        System.out.println(FINAL_WINNER + DELIMITER + referee.getWinnersCarName(generatedCars));
    }
}

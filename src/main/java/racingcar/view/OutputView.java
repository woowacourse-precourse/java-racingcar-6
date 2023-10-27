package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarsGenerateDto;
import racingcar.service.Referee;

public class OutputView {

    private static final String DELIMITER = " : ";

    private static final String FINAL_WINNER = "최종 우승자";

    public void showResultMessage() {
        System.out.println("실행 결과");
    }

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println(car.getCarName() + DELIMITER + car.getPosition().countPositionToString(stringBuilder));
        }
        System.out.println();
    }

    public void showWinner(Referee referee, CarsGenerateDto generatedCars) {
        System.out.println(FINAL_WINNER + DELIMITER + referee.getWinnersCarName(generatedCars));
    }
}

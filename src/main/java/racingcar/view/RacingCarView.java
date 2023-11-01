package racingcar.view;

import static racingcar.model.RacingCarResult.carMovementResult;
import static racingcar.model.RacingCarResult.winnersResult;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;

public class RacingCarView {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASKING_REPEAT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAskingRepeatCountMessage() {
        System.out.println(ASKING_REPEAT_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printAllTravelDistance(RacingCar racingCar) {
        racingCar.getCars().forEach(this::printTravelDistance);
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnersResult = winnersResult(winners);
        System.out.print(winnersResult);
    }

    private void printTravelDistance(Car car) {
        String carMovementResult = carMovementResult(car);
        System.out.println(carMovementResult);
    }
}

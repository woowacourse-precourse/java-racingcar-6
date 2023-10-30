package racingcar.view;

import static racingcar.model.RacingCarResult.carMovementResult;
import static racingcar.model.RacingCarResult.winnersResult;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;

public class RacingCarView {

    private static final String RACING_CAR_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASKING_NUMBER_OF_RETRIES = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PER_RACING = "실행 결과";

    public void printStartRacingCar() {
        System.out.println(RACING_CAR_START);
    }

    public void printAskingNumberOfRetries() {
        System.out.println(ASKING_NUMBER_OF_RETRIES);
    }

    public void printResultPerRacing() {
        System.out.println(RESULT_PER_RACING);
    }

    public void printCarListMovement(RacingCar racingCar) {
        racingCar.getCars().forEach(this::printCarMovement);
        System.out.println();
    }

    public void printFinalMessage(List<Car> winners) {
        String winnersResult = winnersResult(winners);
        System.out.print(winnersResult);
    }

    private void printCarMovement(Car car) {
        String carMovementResult = carMovementResult(car);
        System.out.println(carMovementResult);
    }
}

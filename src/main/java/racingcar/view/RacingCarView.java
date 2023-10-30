package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;

public class RacingCarView {

    private static final String RACING_CAR_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASKING_NUMBER_OF_RETRIES = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PER_RACING = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COLON = ":";
    private static final String ONE_STEP = "-";

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
        String winnersString = convertWinnersToString(winners);
        System.out.print(String.join(" ", FINAL_WINNER, COLON, winnersString));

    }

    private String convertWinnersToString(List<Car> winners) {
        return String.join(",", winners.toString().replace("[", "").replace("]", ""));
    }

    private void printCarMovement(Car car) {
        String movementDistance = ONE_STEP.repeat(car.getMovingDistance());
        System.out.println(String.join(" ", car.toString(), COLON, movementDistance));
    }

}

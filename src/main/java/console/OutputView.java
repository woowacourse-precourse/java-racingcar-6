package console;

import car.Car;
import car.Cars;

import java.util.List;

public class OutputView {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String PROGRESS_PREFIX = " : ";
    private static final String SPLIT_DELIMITER = ", ";
    private static final String LOCATION_COUNTER = "-";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIALS = "시도할 회수는 몇회인가요?";

    public void printGameStart(){
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printTrials(){
        System.out.println(INPUT_TRIALS);
    }

    public void printRoundResult(Cars cars) {
        System.out.println(ROUND_RESULT);
        for (Car car : cars.getCarList()) {
            printCarProgress(car);
        }
        System.out.println();
    }

    private void printCarProgress(Car car) {
        StringBuilder progress = new StringBuilder(car.getName() + PROGRESS_PREFIX);
        for (int i = 0; i < car.getLocation(); i++) {
            progress.append(LOCATION_COUNTER);
        }
        System.out.println(progress);
    }

    public void printWinners(Cars cars){
        List<String> winners = cars.getWinnersNames();
        String winnerName = FINAL_WINNER + String.join(SPLIT_DELIMITER, winners);
        System.out.println(winnerName);
    }
}

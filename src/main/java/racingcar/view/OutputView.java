package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String HYPHEN = "-";

    public void printRaceStartingMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGetTrialsMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printEachTrialResult(List<Car> cars) {
        for (Car car : cars) {
            printEachCarLocation(car);
        }
        System.out.println();
    }

    private void printEachCarLocation(Car car) {
        System.out.println(car.getName() + " : " + getCarLocationString(car));
    }

    private StringBuilder getCarLocationString(Car car) {
        StringBuilder locationOutput = new StringBuilder();
        int carLocation = Math.max(Car.CAR_DEFAULT_LOCATION, car.getLocation());
        locationOutput.append(HYPHEN.repeat(carLocation));
        return locationOutput;
    }
}

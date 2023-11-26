package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.StringConstants;

public class OutputView {
    public void printRequestInputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printRequestInputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatusString(car));
        }
        System.out.println();
    }

    private String getCarStatusString(Car car) {
        String carPositionString = createDashString(car.getPosition().getPosition());
        return car.getName() + " : " + carPositionString;
    }

    private String createDashString(int count) {
        return StringConstants.CURRENT_POSITION.getValue().repeat(Math.max(0, count));
    }

    public void printWinners(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        List<Car> winners = cars.getWinners(maxPosition);
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            if (winnerNames.length() > 0) {
                winnerNames.append(", ");
            }
            winnerNames.append(winner.getName());
        }
        System.out.println("최종 우승자 : " + winnerNames.toString());
    }
}

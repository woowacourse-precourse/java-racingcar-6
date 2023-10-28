package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null)
            outputView = new OutputView();

        return outputView;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printCarListStatus(List<Car> carList) {
        for (Car car : carList) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printWinner(List<Car> winnerCarList) {
        List<String> winnerNameList = winnerCarList.stream()
                .map(car -> car.getName())
                .toList();

        System.out.println(FINAL_WINNER + String.join(", ", winnerNameList));
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
}

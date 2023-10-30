package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.print(car.name + " : ");
            for (int j = 0; j < car.moveCount; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

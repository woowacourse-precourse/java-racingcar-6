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

    public void printWinner(List<Car> maxCarList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < maxCarList.size(); i++) {
            System.out.print(maxCarList.get(i).name);
            if (i + 1 < maxCarList.size()) {
                System.out.print(", ");
            }
        }
    }
}

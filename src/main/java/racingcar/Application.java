package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String[] names = InputView.readCarNames();
        int count = InputView.readTrialCount();

        Cars cars = Cars.createCars(names);

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.calculateMoveCount();
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", cars.getWinner()));
    }
}



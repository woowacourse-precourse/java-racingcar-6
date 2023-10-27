package racingcar;

import racingcar.view.InputView;

public class GameRunner {

    public static void playGame() {
        String[] names = InputView.readCarNames();
        Cars cars = Cars.createCars(names);
        int count = InputView.readTrialCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.calculateMoveCount();
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", cars.getWinner()));
    }
}

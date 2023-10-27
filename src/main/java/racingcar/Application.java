package racingcar;

import domain.RacingCar;
import util.RandomGenerator;
import util.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.printStartMessage();
        RacingCar racingCar = new RacingCar(View.input());
        View.printCycleInputMessage();
        int N = Integer.parseInt(View.input());

        for (int i = 0; i < N; i++) {
            if (racingCar.isMoveForward(RandomGenerator.generateNumber())) {
                racingCar.moveForward();
            };
        }

        System.out.println(racingCar.getLocation());
    }
}

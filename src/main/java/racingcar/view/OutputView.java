package racingcar.view;

import racingcar.model.RacingCar;

public class OutputView {
    public void printRacingCar(final RacingCar racingCar) {
        String racingCarName = racingCar.getName();
        int racingCarPosition = racingCar.getPosition();

        StringBuilder output = new StringBuilder(racingCarName + " : ");

        for (int i = 0; i < racingCarPosition; i++) {
            output.append("-");
        }

        System.out.println(output);
    }
}

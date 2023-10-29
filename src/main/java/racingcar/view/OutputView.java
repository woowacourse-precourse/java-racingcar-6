package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

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

    public void printWinners(final List<String> winners) {
        String output = String.join(", ", winners);

        System.out.println("최종 우승자 : " + output);
    }
}

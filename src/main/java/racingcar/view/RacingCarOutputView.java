package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.utils.Messages;

public class RacingCarOutputView {
    public void moveResultPrint(Integer iterNumber, List<Car> cars) {
        for (int i = 0; i < iterNumber; i++) {
            for (int j = 0; j < cars.size(); j++) {
                Car car = cars.get(j);
                car.moveOrStop();
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

    public void winnerPrint(List<String> winners) {
        System.out.print(Messages.GUIDE_OUTPUT_WINNER);
        if (winners.size() == 1) {
            System.out.println(winners.get(0));
            return;
        }
        System.out.print(String.join(", ", winners));
    }
}

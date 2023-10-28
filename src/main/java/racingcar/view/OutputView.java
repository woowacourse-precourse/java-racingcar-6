package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.MoveCount;
import racingcar.util.RacingGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(RacingGuideMessage racingGuideMessage) {
        System.out.println(racingGuideMessage.getMessage());
    }

    public void renderRace(CarGroup carGroup, MoveCount moveCount) {
        for (int i = 0; i < moveCount.get(); i++) {
            showBlankLine();
            carGroup.run();
            renderRaceStatus(carGroup);
        }
    }

    private void showBlankLine() {
        System.out.println();
    }

    private void renderRaceStatus(CarGroup carGroup) {
        for (Car car : carGroup.getCarGroup()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void showWinners(List<Car> winners) {
        StringJoiner sj = new StringJoiner(", ");
        for (Car car : winners) {
            sj.add(car.getName());
        }
        System.out.println();
        System.out.println("최종 우승자 : " + sj);
    }
}

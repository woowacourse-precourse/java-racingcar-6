package racingcar.view;

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
}

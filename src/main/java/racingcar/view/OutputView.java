package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.MoveCount;
import racingcar.util.RacingGuideMessage;

public class OutputView {

    public void showMessage(RacingGuideMessage racingGuideMessage) {
        System.out.println(racingGuideMessage.getMessage());
    }

    public void renderRace(CarGroup carGroup, MoveCount moveCount) {
        showBlankLine();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount.intValue(); i++) {
            carGroup.run();
            renderRaceStatus(carGroup);
            showBlankLine();
        }
    }

    private void showBlankLine() {
        System.out.println();
    }

    private void renderRaceStatus(CarGroup carGroup) {
        String positionMarker = "-";
        for (Car car : carGroup.getList()) {
            System.out.println(car.getName() + " : " + positionMarker.repeat(car.getPosition()));
        }
    }

    public void showWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

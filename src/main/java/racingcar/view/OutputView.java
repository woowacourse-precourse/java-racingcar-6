package racingcar.view;

import racingcar.domain.CarContainer;
import racingcar.dto.CarPositionDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String CAR_POSITION = "-";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public void printStatusGuide() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printStatus(List<CarPositionDto> racingStatus) {
        racingStatus.forEach(this::printOneStatus);
        System.out.println();
    }

    private void printOneStatus(CarPositionDto racingStatus) {
        System.out.print(racingStatus.getCarName());
        System.out.print(COLON);

        for (int i = 0; i < racingStatus.getStatus(); i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }
    public void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(COLON);
        System.out.print(String.join(",", winners));
        System.out.print("\n");
    }

}

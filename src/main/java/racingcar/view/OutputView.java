package racingcar.view;

import racingcar.dto.CarPositionDto;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String CAR_POSITION = "-";
    private String output;

    public OutputView(String output) {
        this.output = output;
    }

    public void printStatusGuide() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printStatus(List<CarPositionDto> racingStatus) {
        racingStatus.forEach(this::printOneStatus);
    }

    private void printOneStatus(CarPositionDto racingStatus) {
        System.out.println(racingStatus.getCarName());
        System.out.println(COLON);

        for (int i = 0; i < racingStatus.getStatus(); i++) {
            System.out.println(CAR_POSITION);
        }
        System.out.println();
    }

}

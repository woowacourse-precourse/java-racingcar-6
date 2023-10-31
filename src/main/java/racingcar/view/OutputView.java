package racingcar.view;

import racingcar.DTO.CarDTO;

import java.util.List;

public class OutputView {
    private static final String DISPLAY_FORMAT = "-";
    private static final String SEPARATOR = ", ";
    private enum OutputMessage {
        ROUND_RESULT("실행 결과"),
        WINNING_STATUS("최종 우승자 : ");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public void printPlayStart() {
        System.out.println(OutputMessage.ROUND_RESULT.message);
    }

    public void printRoundResult(List<CarDTO> roundResult) {
        for (CarDTO carStatus : roundResult) {
            String carName = carStatus.getName();
            String movementCount = calculateMovementCount(carStatus.getPosition());
            System.out.printf("%s : %s%n", carName, movementCount);
        }
    }

    public String calculateMovementCount(int position) {
        return DISPLAY_FORMAT.repeat(position);
    }
}

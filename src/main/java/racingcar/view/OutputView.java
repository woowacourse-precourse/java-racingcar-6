package racingcar.view;

import racingcar.DTO.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

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
        System.out.printf("%n%s%n", OutputMessage.ROUND_RESULT.message);
    }

    public void printRoundResult(List<CarDTO> roundResult) {
        for (CarDTO carStatus : roundResult) {
            String carName = carStatus.getName();
            String movementCount = calculateMovementCount(carStatus.getPosition());
            System.out.printf("%s : %s%n", carName, movementCount);
        }
        System.out.printf("%n");
    }

    public void printWinner(List<CarDTO> finalResult) {
        System.out.print(OutputMessage.WINNING_STATUS.message);
        System.out.print(extractWinnerNames(finalResult));
    }

    public String calculateMovementCount(int position) {
        return DISPLAY_FORMAT.repeat(position);
    }

    public String extractWinnerNames(List<CarDTO> finalResult) {
        return finalResult.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(SEPARATOR));
    }
}

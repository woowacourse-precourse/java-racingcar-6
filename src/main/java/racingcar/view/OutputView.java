package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarDTO;
import racingcar.domain.car.RoundResult;
import racingcar.domain.car.Winners;

public class OutputView {

    private static final String DELIMITER_COLON = " : ";
    private static final String BAR = "-";
    private static final String DELIMITER_COMMA = ", ";
    private static final String FINAL_WINNER = "최종 우승자";

    public void printRoundResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printRoundResult(RoundResult roundResult) {
        List<CarDTO> carDTOs = roundResult.carDTOs();

        carDTOs.forEach(carDTO ->
                System.out.println(carDTO.getName() + DELIMITER_COLON + BAR.repeat(carDTO.getPosition()))
        );
        System.out.println();
    }

    public void printWinners(Winners winners) {
        List<CarDTO> carDTOs = winners.carDTOs();
        String winnersFormat = getWinnersFormat(carDTOs);
        System.out.println(FINAL_WINNER + DELIMITER_COLON + winnersFormat);
    }


    private String getWinnersFormat(List<CarDTO> carDTOs) {
        return carDTOs.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
    }
}
package racingcar.view;

import java.util.List;
import racingcar.domain.car.CarDTO;
import racingcar.domain.car.RoundResult;

public class OutputView {

    private static final String DELIMITER = " : ";
    private static final String BAR = "-";

    public void printRoundResultMessage() {
        System.out.println("실행결과");
    }

    public void printRoundResult(RoundResult roundResult) {
        List<CarDTO> carDTOs = roundResult.carDTOs();

        carDTOs.forEach(carDTO ->
                System.out.println(carDTO.getName() + DELIMITER + BAR.repeat(carDTO.getPosition()))
        );
        System.out.println();
    }
}
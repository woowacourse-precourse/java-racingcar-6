package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;

public class OutputView {
    private static final String CAR_STATE_DELIMITER = ":";
    private static final String POSITION_SYMBOL = "-";
    private static final String START_RESULT_MESSAGE = "실행 결과";


    public void printStartResultMessage() {
        printNewLine();
        System.out.println(START_RESULT_MESSAGE);
    }
    public void printRoundResult(List<CarDTO> carDTOList) {
        carDTOList.forEach(this::printCarPosition);
        printNewLine();
    }

    private void printCarPosition(CarDTO carDTO) {
        String name = carDTO.getName();
        int position = carDTO.getPosition();
        String positionString = POSITION_SYMBOL.repeat(position);
        System.out.println(name + CAR_STATE_DELIMITER + positionString);
    }

    private void printNewLine() {
        System.out.println();
    }
}

package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;

public class OutputView {
    private static final String CAR_STATE_DELIMITER = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String START_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";


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

    public void printRaceResult(List<CarDTO> winnerList) {
        StringBuilder raceResult = new StringBuilder(WINNER_MESSAGE);
        winnerList.forEach(carDTO -> appendWinnerWithComma(carDTO, raceResult));
        System.out.println(stripLastComma(raceResult));
    }

    private static String stripLastComma(StringBuilder raceResult) {
        return raceResult.substring(0, raceResult.length() - 2);
    }

    private static StringBuilder appendWinnerWithComma(CarDTO carDTO, StringBuilder raceResult) {
        return raceResult.append(carDTO.getName()).append(", ");
    }
}

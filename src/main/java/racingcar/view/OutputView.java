package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {
    public void printSingleRound(List<CarDto> carDistanceList) {
        StringBuilder result = new StringBuilder();

        for (CarDto carDistance : carDistanceList) {
            String carName = carDistance.getCarName();
            int movedDistance = carDistance.getMovedDistance();

            addCarMovingLine(result, carName, movedDistance);
        }
        System.out.println(result);
    }

    private void addCarMovingLine(StringBuilder result, String carName, int movedDistance) {
        result.append(carName + " : ");
        for (int i = 0; i < movedDistance; i++) {
            result.append("-");
        }
        result.append("\n");
    }

    public String printWinner(List<String> winners) {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");
        appendWinner(result, winners);
        String formattedResult = result.substring(0, result.length() - 2);
        System.out.println(formattedResult);
        return formattedResult;
    }

    private void appendWinner(StringBuilder result, List<String> winners) {
        for (String winner : winners) {
            result.append(winner + ", ");
        }
    }
}

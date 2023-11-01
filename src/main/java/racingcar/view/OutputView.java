package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    //실행 결과 출력 (컨트롤러로부터 데이터 받음)
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
        result.append(carName+" : ");
        for (int i=0; i<movedDistance; i++) {
            result.append("-");
        }
        result.append("\n");
    }

    //최종 우승자 출력(중복가능)
    public String printWinner(List<CarDto> carDistanceList) {
        StringBuilder winner = new StringBuilder();
        winner.append("최종 우승자 : ");
        int max = 0;
        int tieWinnerCount = 0;
        for (CarDto carDto : carDistanceList) {
            if (max < carDto.getMovedDistance()) {
                max = carDto.getMovedDistance();
                tieWinnerCount++;
            }
        }

        for (CarDto carDto : carDistanceList) {
            if (max == carDto.getMovedDistance()) {
                winner.append(carDto.getCarName()+", ");
            }
        }
        winner.substring(0,winner.length());

        System.out.println(winner.substring(0,winner.length()-2));
        return winner.toString().substring(0,winner.length()-2);
    }

}

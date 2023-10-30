package racingcar;

import java.util.List;

public class CarView {
    //이름 입력 받는 문장 출력
    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    //시도할 회수 받는 문장 출력
    public void printInputHowManyRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    //실행 결과 출력 (컨트롤러로부터 데이터 받음)
    public void printResult(List<CarDto> carDistanceList) {
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

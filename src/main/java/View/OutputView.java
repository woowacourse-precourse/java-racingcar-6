package View;

import java.util.List;
import Model.RacingCar;

public class OutputView {
    private static final String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void printStart(){
        System.out.println(START);
    }

    public void printTrial(){
        System.out.println(TRIAL);
    }

    public void printResult(List<RacingCar> RacingCars){
        System.out.println(RESULT);
        for (RacingCar racingCar : RacingCars){
            System.out.println(racingCar.getName() + " : " + racingCar.visibleDistance());
        }
    }

    public void printWinner(List<String> Winners){
        System.out.println(WINNER + String.join(", ", Winners));
    }
}

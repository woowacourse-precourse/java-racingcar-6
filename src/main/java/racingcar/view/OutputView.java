package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {}

    public static OutputView getInstance(){
        return INSTANCE;
    }

    public void printPlayResultMessage(){
        System.out.println("실행 결과");
    }

    public void printCarName(Car car){
        System.out.print(car.getCarName() + " : ");
    }

    public void printCurrentCarPosition(Car car){
        for(int currentCarPosition = 0 ; currentCarPosition < car.getAdvanceCount(); currentCarPosition++){
            System.out.print("-");
        }
    }

    public void printFinalWinner(List<String> winners){
        String winnerList = String.join(",", winners);
        System.out.println("최종 우승자 : " + winnerList);
    }

}

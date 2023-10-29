package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputView {
    public static void gameResultMessge(){
        System.out.println("실행 결과");
    }
    public static void moveDistanceMessage(RacingCar racingCar){
        System.out.println(racingCar.getName()+" : "+ racingCar.getDistanceAsBar());
    }
    public static void printFinalWinner(List<String> winners){
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : "+result);
    }
}

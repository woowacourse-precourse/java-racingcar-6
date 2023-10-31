package racingcar.view;

import java.util.List;

public class OutputView {
    public void printWinner(List<String> winner){
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
    public void printEachFoward(String carName,String carForward){
        System.out.println(carName + " : "+ carForward);
    }
}

package racingcar.domain;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printRoundResult(List<Car> cars){
        for(Car car : cars){
            String messge = "";
            messge+= car.getName();
            messge+=" : ";
            for(int i=0;i<car.getTotalMovedDistance();i++){
                messge += "-";
            }
            System.out.println(messge);
        }
    }
}

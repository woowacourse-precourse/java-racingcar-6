package racingcar.domain;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    private final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    private final String DELIMITER = ", ";

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
    private String makeGameResultMessage(List<String> cars){
        String message = WINNER_OUTPUT_MESSAGE;
        for(int i=0;i< cars.size()-1;i++){
            message += (cars.get(i) + DELIMITER);
        }
        message +=cars.get(cars.size()-1);
        return message;
    }
}

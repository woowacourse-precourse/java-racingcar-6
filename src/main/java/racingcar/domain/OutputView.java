package racingcar.domain;

import java.util.List;

public class OutputView {
    private final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    private final String DELIMITER = ", ";

    public void printRoundResult(List<Car> cars){
        for(Car car : cars){
            makeRoundResultMessage(car);
        }
        System.out.println();
    }

    private void makeRoundResultMessage(Car car) {
        String messge = "";
        messge+= car.getName();
        messge+=" : ";
        for(int i = 0; i< car.getTotalMovedDistance(); i++){
            messge += "-";
        }
        System.out.println(messge);
    }

    public void printWinners(List<String> cars){
        System.out.println(makeGameResultMessage(cars));
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

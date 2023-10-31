package view;

import java.util.List;
import model.Car;
import model.Cars;
import model.Winners;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String DISTANCE_SYMBOL = "-";
    private final String FINAL_WINNER = "최종 우승자 : ";

    public void displayResultMessage(){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void displayRoundStatus(Cars cars){
        for (Car car : cars.getCars()){
            System.out.println(displayCarStatus(car));
        }
        System.out.println();
    }

    public void displayWinners(Winners winners){
        System.out.print(FINAL_WINNER + String.join(", ",winners.getNames()));
    }

    private String displayCarStatus(Car car){
        int carPosition = car.getPosition();
        String carPositionSymbol = markDistanceSymbol(carPosition);
        return car.getName() + " : " + carPositionSymbol;
    }

    private String markDistanceSymbol(int position){
        return DISTANCE_SYMBOL.repeat(position);
    }




}

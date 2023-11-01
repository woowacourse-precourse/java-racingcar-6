package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static final String RESULT_START_MESSAGE = "실행 결과";
    public static final String RESULT_WINNER_MESSAGE = "최종 우승자 :";

    public static String middleEachResult(Car car){
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName() + " : ");
        for(int i=0; i< car.getForward(); i++){
            sb.append("-");
        }
        sb.append("\n");

        return sb.toString();
    }
    public static String middleResult(List<Car> cars){
        StringBuilder sb = new StringBuilder();

        for(Car c : cars){
            sb.append(middleEachResult(c));
        }

        return sb.toString();
    }

}

package racingcar.domain;

import java.util.ArrayList;

public class OutputResultOfMove {
    private final static String runMessage = "\n실행 결과";

    public OutputResultOfMove(){
        System.out.println(runMessage);
    }

    public void printResultOfMove(ArrayList<Car> carList){
        for (Car nowCar : carList) {
            System.out.println(nowCar.getCarInfo());
        }
        System.out.println();
    }
}

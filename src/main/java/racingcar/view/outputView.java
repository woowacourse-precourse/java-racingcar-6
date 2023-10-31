package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;

public class outputView {

    public static void printMessage(CarList carList){
        System.out.println("실행 결과");
        for (Car car : carList.getCarList()){
            System.out.print(car.toString());
        }
    }

    public static void winner(CarList carList) {

    }
}

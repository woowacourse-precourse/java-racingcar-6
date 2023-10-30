package view;

import model.Car;
import model.Cars;

public class OutputView {
    static final String EXECUTION_RESULT = "실행 결과";
    public void printCarsPosition(Cars cars) {
        System.out.println(EXECUTION_RESULT);
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getNowPlace());
        }
    }
}

package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        ArrayList<Car> carList = carService.createCarImpl(carService.inputCarName());
        carService.resultPrint(carList, carService.tryingNumber());
        carService.findWinner(carList);
    }
}

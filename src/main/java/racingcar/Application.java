package racingcar;

import racingcar.game.CarList;
import racingcar.view.DataIOHandler;

public class Application {
    public static void main(String[] args) {
        String commaSeparatedNames = DataIOHandler.getNameInput();
        Integer tryCount = DataIOHandler.getTryCountInput();

        CarList carList = new CarList(commaSeparatedNames);

        carList.tryAllCars();
        carList.tryAllCars();
        carList.tryAllCars();
        carList.printCarsStatus();
        System.out.println(carList.getLongestDistanceNames());
    }
}

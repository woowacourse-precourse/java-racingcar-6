package View;

import Model.Car;
import java.util.ArrayList;

public class carRaceOutputService {

    private static carRaceOutputService outputView = null;
    private static final String CAR_MOVE_SEPERATOR = ":";

    private static final String CARS_SEPERATOR = ",";

    public static carRaceOutputService getInstance() {
        if (carRaceOutputService.outputView == null) {
            return carRaceOutputService.outputView = new carRaceOutputService();
        }
        return carRaceOutputService.outputView;
    }

    private void printCarName(String carName) {
        System.out.print(carName + " " + CAR_MOVE_SEPERATOR + " ");
    }

    private void printCarMoves(int carMoves) {
        for (int move = 0; move < carMoves; move++) {
            System.out.print("-");
        }

        System.out.print("\n");
    }

    public void printCarStatus(Car car) {
        this.printCarName(car.getName());
        this.printCarMoves(car.getMoves());

    }


}

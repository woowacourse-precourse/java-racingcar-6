package racingcar.View;

import racingcar.Model.Car;
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

    public void askGameRound() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askCarNames() {
        System.out.println("시도할 회수는 몇회인가요?");
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

    public void printRaceResult(ArrayList<Car> cars) {
        System.out.print("최종 우승자 : ");
        for (int car = 0; car < cars.size(); car++) {
            System.out.print(cars.get(car).getName());

            if (car != cars.size() - 1) {
                System.out.print(CARS_SEPERATOR + " ");
            }

        }
    }


}

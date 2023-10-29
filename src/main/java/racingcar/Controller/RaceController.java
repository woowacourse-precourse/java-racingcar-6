package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.CarComparator;
import racingcar.CarList;
import racingcar.Model.Car;
import racingcar.View.ConsolePrint;

public class RaceController {

    private CarList carList;

    public void start() {
        carList = new CarList(ConsolePrint.readCars().split(","));

//        System.out.println(carList);
        int tryNum = Integer.parseInt(ConsolePrint.readTryNum());
        race(tryNum);
        findWinner();
    }

    void race(int tryNum) {
        ConsolePrint.printOpening();

        for (int i = 0; i < tryNum; i++) {
            move();
            ConsolePrint.printRace(carList.getCarList());
        }
    }

    void move() {
        for (Car car : carList.getCarList()) {
            if (3 < Randoms.pickNumberInRange(0, 9)) {
                car.incrementDistance();
            }
        }
    }

    void findWinner() {
        List<Car> sorted = carList.getCarList().stream()
                .sorted(new CarComparator())
                .collect(Collectors.toList());
        for (Car car : sorted) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        ConsolePrint.printWinner(sorted);
    }

}

package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.CarComparator;
import racingcar.Model.Car;
import racingcar.View.ConsolePrint;

public class RaceController {

    private List<Car> carList = new ArrayList<Car>();

    public void start() {
        String[] names = ConsolePrint.readCars().split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        System.out.println(carList);
        int tryNum = Integer.parseInt(ConsolePrint.readTryNum());
        race(tryNum);
        findWinner();

    }

    void race(int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            move();
            ConsolePrint.printRace(carList);
        }
    }

    void move() {
        for (Car car : carList) {
            if (3 < Randoms.pickNumberInRange(0, 9)) {
                car.incrementDistance();
            }
        }
    }

    void findWinner() {
        carList = carList.stream().sorted(new CarComparator()).collect(Collectors.toList());
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        ConsolePrint.printWinner(carList);
    }

}

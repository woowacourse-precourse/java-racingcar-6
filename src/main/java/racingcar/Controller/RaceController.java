package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.CarComparator;
import racingcar.CarList;
import racingcar.Model.Car;
import racingcar.TryNumber;
import racingcar.View.ConsolePrint;

public class RaceController {

    private CarList carList;

    private TryNumber tryNumber;

    public RaceController() {
    }

    public RaceController(CarList list) {
        this.carList = list;
    }

    public void start() {
        carList = new CarList(ConsolePrint.readCars().split(","));

//        System.out.println(carList);
        tryNumber = new TryNumber(ConsolePrint.readTryNum());
        race(tryNumber.getTryNum());
        findWinner();
    }


    public void race(int tryNum) {
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

    public void findWinner() {
        List<Car> sorted = carList.getCarList().stream()
                .sorted(CarComparator.getInstance())
                .collect(Collectors.toList());
//        for (Car car : sorted) {
//            System.out.println(car.getName() + " : " + car.getDistance());
//        }
        ConsolePrint.printWinner(sorted);
    }

}

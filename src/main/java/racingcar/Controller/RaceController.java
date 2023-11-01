package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.Model.CarList;
import racingcar.Model.TryNumber;
import racingcar.Utils.CarComparator;
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

        ConsolePrint.printWinner(sorted);
    }

}

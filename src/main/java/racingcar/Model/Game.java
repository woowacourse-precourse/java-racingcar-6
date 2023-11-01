package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.Util.Exceptions;

public class Game {
    private List<Car> carList = new ArrayList<>();
    private final int repetition;


    public Game(List<String> carNames, int repetition) {
        Exceptions exception = new Exceptions();
        exception.hasWrongName(carNames);
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        this.repetition = repetition;
    }

    public void forward() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < repetition; i++) {
            for (Car car : carList) {
                car.go(Randoms.pickNumberInRange(1, 9));
            }
            System.out.println();
        }
    }

    public void result() {
        carList.sort(comparator);
        Car winner = carList.get(0);
        winner.win();
        for (int i = 1; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (car.getDistance() == winner.getDistance()) {
                car.jointWin();
            }
        }
    }

    private Comparator<Car> comparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car2.getDistance() - car1.getDistance();
        }
    };
}

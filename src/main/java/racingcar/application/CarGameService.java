package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.MoveCommandMaker;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CarGameService {
    private final MoveCommandMaker moveCommandMaker;

    private final Referee referee;

    private final int MIN_CAR = 1;

    public CarGameService(MoveCommandMaker moveCommandMaker, Referee referee) {
        this.moveCommandMaker = moveCommandMaker;
        this.referee = referee;
    }

    public List<Car> initCars(List<String> names) throws IllegalArgumentException{
        assertValidMinCar(names);

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveCar(Car car) {
        car.move(moveCommandMaker.makeMoveCommand(Randoms.pickNumberInRange(0,9)));
    }

    public List<Car> winners(List<Car> cars) {
        return referee.getWinnerCars(cars);
    }

    private void assertValidMinCar(List<String> names) {
        if (names.size() < MIN_CAR) {
            throw new IllegalArgumentException("최소 1개 이상의 차가 필요합니다.");
        }
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

}

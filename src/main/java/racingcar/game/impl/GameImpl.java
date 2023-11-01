package racingcar.game.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.game.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameImpl implements Game {
    private List<Car> cars;
    private final int moveNumber;

    public GameImpl(List<Car> cars, int moveNumber) {
        this.cars = cars;
        this.moveNumber = moveNumber;
    }

    private void tryMove() {
        cars.forEach(car -> {
            int dice = Randoms.pickNumberInRange(0, 9);
            if (dice >= 4) {
                car.move();
            }
            car.printProcess();
        });
    }

    @Override
    public void play() {
        for (int i = 0 ; i < moveNumber ; i++) {
            tryMove();
        }
        this.cars = this.cars.stream()
                .sorted(Comparator.comparingInt(Car::getMovedDistance))
                .collect(Collectors.toList());
    }

    @Override
    public void end() {
        int criteria = this.cars.get(0).getMovedDistance();
        int length = this.cars.size();
        System.out.print("최종우승자 : " + cars.get(0).getName());
        for (int i = 1 ; i < length; i++) {
            Car car = cars.get(i);
            if (criteria == car.getMovedDistance()) {
                System.out.print(", " + car.getName());
            }
        }
        System.out.println();
    }
}

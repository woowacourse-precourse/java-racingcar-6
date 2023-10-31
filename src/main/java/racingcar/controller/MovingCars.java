package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.Order;
import racingcar.view.RotatingCount;

import java.util.List;

public class MovingCars {
    private RotatingCount rotatingCount = new RotatingCount();
    private Order order = new Order();
    public void start(List<Car> carList) {
        int total = rotatingCount.input();

        for(int count = 0; count < total; count++){
            moveOrStop(carList);
            checkLocation(carList);
            order.blank();
        }
    }

    private void checkLocation(List<Car> carList) {
        for (Car car : carList) {
            printLocation(car);
        }
    }

    private void moveOrStop(List<Car> carList) {
        for (Car car : carList) {
            int state = Randoms.pickNumberInRange(0, 9);

            if (step(state)) {
                String cur = car.getMove();
                move(car, order.step(cur));
            }
        }
    }

    private boolean step(int state) {
        return state > 3;
    }

    private void printLocation(Car car) {
        System.out.println(car.toString());
    }

    private void move(Car car, String next) {
        car.setMove(next);
    }
}

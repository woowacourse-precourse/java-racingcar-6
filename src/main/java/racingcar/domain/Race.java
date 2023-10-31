package racingcar.domain;


import java.util.List;

public class Race {

    private void forwardOrNot(List<Car> cars) {

        for (Car car : cars) {
            if (car.shouldCarMove()) {
                car.forward += "-";
                car.addForwardCount();
            }
            System.out.println(car.getName() + " : " + car.getForward());
        }
        System.out.println();
    }

    public void startRace(List<Car> cars, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            forwardOrNot(cars);
        }
    }
}

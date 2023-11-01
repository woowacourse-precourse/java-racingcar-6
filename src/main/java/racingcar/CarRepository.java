package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private List<Car> cars = new ArrayList<>();


    public void add(Car car) {
        this.cars.add(car);
    }

    public void setCarForward() {
        for (Car car : this.cars) {
            if (car.setRandomNumber() >= 4) {
                car.setForward();
            }
        }
    }

    public void getCarStatus() {
        for (Car car : this.cars) {
            System.out.println(car.getName() + " : " + car.getForward());
        }
    }

    public void getWinner() {
        List<String> winners = new ArrayList<>();
        System.out.print("최종 우승자 : ");
        int max = getMaxForwardLength();
        for (Car car : this.cars) {
            if (car.getForward().length() >= max) {
                winners.add(car.getName());
            }
        }
        String winnerList = String.join(", ", winners);
        System.out.println(winnerList);

    }


    public int getMaxForwardLength() {
        int max = 0;
        for (Car car : this.cars) {
            if (max < car.getForward().length()) {
                max = car.getForward().length();
            }
        }
        return max;
    }

}

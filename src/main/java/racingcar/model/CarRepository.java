package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public enum CarRepository {
    INSTANCE;
    private List<Car> carList = new ArrayList<Car>();

    public void addCar(List<String> nameList) {
        for(String name : nameList) {
            carList.add(new Car(name));
        }
    }

    public void go(int numberExcution) {
        for(int i=0; i<numberExcution; i++) {
            for(Car car : carList) {
                car.go();
            }
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinners() {
        int numberWin = winnerScore();
        List<Car> winners = new ArrayList<Car>();

        for (Car car : carList) {
            if (car.getGo() == numberWin) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int winnerScore() {
        int result = 0;
        for(Car car : carList) {
            int carGo = car.getGo();
            if(result < carGo) {
                result = carGo;
            }
        }
        return result;
    }
}

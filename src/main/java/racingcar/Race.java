package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public Car[] setCars(String[] carNameList) {
        Car[] cars = new Car[carNameList.length];

        for(int i = 0; i < carNameList.length; i++) {
            cars[i] = new Car();
            cars[i].setCarName(carNameList[i]);
        }

        return cars;
    }

    public Car[] racingCount(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int num = Randoms.pickNumberInRange(0, 9);
            cars[i].setAdvanceCount(num);
        }
        return cars;
    }

    public List<String> getWinnerList(Car[] cars) {
        List<String> winner = new ArrayList<>();
        int max = 0;

        for(Car car : cars) {
            if(car.getAdvanceCount() == max) {
                winner.add(car.getCarName());
            }
            if(car.getAdvanceCount() > max) {
                winner.clear();
                winner.add(car.getCarName());
                max = car.getAdvanceCount();
            }
        }

        return winner;
    }
}

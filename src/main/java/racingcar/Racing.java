package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;

    public Racing(List<String> nameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {
            Car car = new Car(nameList.get(i), 0);
            carList.add(car);
        }

        this.carList = carList;
    }

    public String startRacing(int round) {
        StringBuilder racingResult = new StringBuilder();

        for (int i = 0; i < round; i++) {
            racingResult.append("\n");
            for (Car car : carList) {
                move(car);
                racingResult.append(car.result());
            }
        }
        return racingResult.toString();
    }

    private void move(Car car) {
        if (isGo()) {
            car.move += 1;
        }
    }

    private Boolean isGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public List<String> determineWinner() {
        int maxMove = getMax();
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.move == maxMove) {
                winner.add(car.name);
            }
        }

        return winner;
    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.move > max) {
                max = car.move;
            }
        }
        return max;
    }
}


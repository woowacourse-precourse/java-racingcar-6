package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Referee {
    private ArrayList<Car> cars;

    public Referee(ArrayList<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    // 각 자동차마다 값을 랜덤으로 뽑아 Car.position 값 변경
    public ArrayList<Car> playRound(ArrayList<Car> cars) {
        for (Car car : cars) {
            int move = Randoms.pickNumberInRange(1,9);
            System.out.println("move = " + move);
            if (move >= 4) {
                car.carMove(move);
                System.out.println("carPosition = " + car.getPosition());
            }
        }
        return cars;
    }

    public ArrayList<Car> determineWinner(ArrayList<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
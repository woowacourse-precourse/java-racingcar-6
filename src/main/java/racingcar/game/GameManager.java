package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static final int stdNum = 4;
    private List<Car> carList;

    public GameManager(List<String> nameList) {
        this.carList = Car.generateCarList(nameList);
    }
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public void moveCar(Car car) {
        int randomNumber = generateRandomNumber();

        if(randomNumber >= stdNum) {
            car.move();
        }
    }

    public void proceedRound() {
        this.carList.forEach(car -> {
            moveCar(car);
        });
    }

    public List<String> getWinner() {
        int max = getMaxDistance();
        List<String> winnerList = new ArrayList<>();

        for(Car car : carList){
            int distance = car.getDistance().length();

            if(distance == max) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    public int getMaxDistance() {
        int max = Integer.MIN_VALUE;

        for(Car car : carList) {
            int distance = car.getDistance().length();
            if(distance> max) {
                max = distance;
            }
        }
        return max;
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}

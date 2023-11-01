package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;
    private List<Car> cars;

    private List<Car> generateCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private void RunTurn(List<Car> cars){
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if(randomNumber >= 4){
                car.moveForward();
            }
        }
    }

    public PlayGame(String[] carNames, int attemptsNumber){
        List<Car> cars = new ArrayList<>();
        cars = generateCarList(carNames);
        Print print = new Print();

        for(int i = 0; i<attemptsNumber; i++){
            RunTurn(cars);
            print.status(cars);
        }
        print.result(cars);
    }

}

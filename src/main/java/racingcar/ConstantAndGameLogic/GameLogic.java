package racingcar.ConstantAndGameLogic;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.View.User_Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameLogic {
    private final List<Car> cars;
    private int moveingNumber;

    public GameLogic(){
        cars = new ArrayList<>();
    }

    public void registerCarName(List<String> cars){
        for (String car : cars){
            this.cars.add(new Car(car));
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public void registerMovingNumber(int moveNumber){
        this.moveingNumber = moveNumber;
    }

    public int getMovingPosition(){
        return moveingNumber;
    }

    public void racingStart(){
        for (Car car : cars){
            car.decisionToMove(getRandomNumber());
        }
        moveingNumber--;
    }

    public boolean checkIsOver(){
        return moveingNumber == 0;
    }
    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public List<String> selectWinners(){
        return cars.stream()
                .filter(car -> car.getCurrentLocation() == cars.stream().map(Car::getCurrentLocation)
                .max(Integer::compareTo).orElse(0))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
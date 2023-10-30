package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private final int MOVE_CONDITION = 4;
    private final int START_RANGE = 1;
    private final int END_RANGE = 9;
    private final int MOVE_NUMBER = 1;
    public List<String> splitCarNames(String input){
        String [] carString = input.split(",");
        List<String> carList = new ArrayList<String>(Arrays.asList(carString));
        return carList;
    }
    public void moveRandomNumber(List<Car> cars){
        for(Car car : cars){
            if(MOVE_CONDITION < getRandomNumber()){
                car.moveCar(MOVE_NUMBER);
            }
        }
    }
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(START_RANGE,END_RANGE);
    }
}

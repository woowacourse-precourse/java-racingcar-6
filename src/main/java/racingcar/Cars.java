package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void set(String input){
        List<String> carNameList = parsingCarNames(input);
        storeCars(carNameList);
    }

    public List<String> parsingCarNames(String carNames){
        List<String> carNameList = splitAndConvertToList(carNames, ",");

        return carNameList;
    }

    public void storeCars(List<String> carList){
        for(String carName : carList){
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars(){
        return this.cars;
    }

    public List<String> splitAndConvertToList(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public void moveAll(){
        for(Car car : cars){
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCarPositions(){
        for(Car car : cars){
            car.printStatus();
        }
    }
}

package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import model.CarList;

import java.util.List;
import java.util.Random;

public class ProcessHelper {

    private final Validation validation = new Validation();

    public void addCarToCarList(){
    }
    public String[] commaSeperate(final String input){
        String[] inputArray = input.split(",");
        validation.carNameValidation(inputArray);
        return inputArray;
    }
    public CarList makeCarList(final String[] carNameArray){
        CarList carList = new CarList();
        for(String str : carNameArray){
            carList.addCar(str);
        }
        return carList;
    }
    public List<Car> raceCars(List<Car> carList){
        for(Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >= 4) {
                car.addForwardCount();
            }
        }
        return carList;
    }
    public void printRaceResultByRound(List<Car> carList){
        for(Car car : carList){
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getForwardCount()));
        }
    }

}

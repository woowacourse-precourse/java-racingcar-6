package service;

import domain.Car;
import domain.Cars;
import ui.Input;
import util.CarList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputCarNameFactory {

    //TODO .., 입력, empty 입력 등등 처리
    public Cars createCars(){
        String[] carNameInputArray = processCarNameInput();
        if(carNameInputArray.length==0) throw new IllegalArgumentException("적절하지 않은 이름입니다");

        CarList<Car> carList = new CarList<>();
        for(String name:carNameInputArray){
            Car car = new Car(name);
            if(carList.contains(car)) throw new IllegalArgumentException("중복된 이름입니다");
            carList.add(new Car(name));
        }

        return new Cars(carList);
    }

    //Input 데이터 가공
    private String[] processCarNameInput() {
        return Arrays.stream(Input.input.split(","))
                .map(String::trim)
                .peek(carName -> {
                    if (!isValid(carName)) {
                        throw new IllegalArgumentException("5글자를 초과했습니다.");
                    }
                })
                .toArray(String[]::new);
    }

    private boolean isValid(String carName){
        return carName.length()<=5;
    }
}

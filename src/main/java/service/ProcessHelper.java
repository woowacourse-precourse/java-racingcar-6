package service;

import java.util.ArrayList;
import java.util.List;

import model.CarList;
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
}

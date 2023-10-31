package racingcar.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import racingcar.service.ListConvert;
import racingcar.service.CarNameValidation;

import static racingcar.consts.ConstString.DELIMITER;

public class CreateCarList {
    ListConvert listConvert = new ListConvert();
    CarNameValidation carNameValidation = new CarNameValidation();
    public HashMap<String, Integer> newCar = new LinkedHashMap<>();

    public HashMap<String, Integer> createCarNameList(String carInput){
        List<String> carList = splitCarList(carInput);
        for(String carName : carList){
            newCar.put(carName,0);
        }
        return newCar;
    }

    private List<String> splitCarList(String carInput){
        List<String> carList = listConvert.convertToList(carInput.split(DELIMITER));
        carNameValidation.validateCarName(carList);
        return carList;
    }
}

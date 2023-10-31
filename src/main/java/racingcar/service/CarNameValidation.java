package racingcar.service;

import static racingcar.consts.ConstString.MAX_SIZE;
import static racingcar.consts.ConstString.MAX_SIZE_ERROR;
import static racingcar.consts.ConstString.DUPLICATED_VALUE_ERROR;
import static racingcar.consts.ConstString.MIN_CAR_ERROR;
import static racingcar.consts.ConstString.WRONG_SEPERATOR_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidation {
    public void validateCarName(List<String> carList){
        checkValidSplit(carList);
        checkCarNameSize(carList);
        checkCarListSize(carList);
        checkDupliacted(carList);
    }
    private static void checkCarNameSize(List<String> carList){
        for(String carName : carList){
            if(carName.length() > MAX_SIZE){
                throw new IllegalArgumentException(MAX_SIZE_ERROR);
            }
        }
    }

    private static void checkCarListSize(List<String> carList){
        for(String carName : carList){
            if(carName.isEmpty()){
                throw new IllegalArgumentException(MIN_CAR_ERROR);
            }
        }
    }

    private static void checkDupliacted(List<String> carList){
        Set<String> carset = new HashSet<>();
        for(String carName : carList){
            carset.add(carName);
        }
        if(carset.size() != carList.size()){
            throw new IllegalArgumentException(DUPLICATED_VALUE_ERROR);
        }
    }

    private static void checkValidSplit(List<String> carList){
        String userInput = carList.toString();
        if(!userInput.contains(",")){
            throw new IllegalArgumentException(WRONG_SEPERATOR_ERROR);
        }
    }
}

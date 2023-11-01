package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.ErrorMessage;

public class viewInputCar {
    private final String DELIMITER = ",";
    public String[] viewInputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameData = Console.readline();
        InputCarValidation(carNameData);
        String[] carNameArray = carNameData.split(DELIMITER);
        return carNameArray;
    }
    private void InputCarValidation(String name) throws IllegalArgumentException{
        String[] carArray = name.split(DELIMITER);

        Set<String> carSet = new HashSet<>();
        for(String item : carArray){
            carSet.add(item);
        }
        if(carArray.length != carSet.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_EXCEPTION.getMessage());
        }
        for(String item : carArray){
            if(item.length() > 5){
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
            }
        }
    }

}

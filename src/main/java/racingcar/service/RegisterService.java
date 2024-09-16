package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterService {
    public List<String> convertCarNameToList(String inputCarName){
        return Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void validateCarName(List<String> carList,String inputCarName){
        //예외1 : , 구분자 오류
        if(carList.size() != inputCarName.split(",").length){
            throw new IllegalArgumentException();
        }

        //예외2 : 이름 길이 오류
        for(String name : carList){
            if(name.length()<=0 || name.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateInputMovementNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public int convertNumberToInt(String inputNumber){
        return Integer.parseInt(inputNumber);
    }
}

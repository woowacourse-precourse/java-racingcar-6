package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCar {
    public final List<String> Cars=new ArrayList<>();
    private static final int MAX_NAME_LENGTH_RANGE = 5;
    private static final String ERROR_INVALID_INPUT="[ERROR] INPUT ERROR(입력된 자동차 수 초과 or 입력된 자동차 이름 길이 초과)";
    public UserCar(String CarsInput){
        String[] splitStr = CarsInput.split(",");
        validateAllCarNameLength(splitStr);
        Cars.addAll(Arrays.asList(splitStr));
    }
    public void PrintAllCars(){
        for (String car: Cars){
            System.out.println("입력된 차 이름: "+car);
        }
    }
    private void validateAllCarNameLength(String[] splitStr){
        for(String carName:splitStr){
            validateCarNameLength(carName);
        }
    }
    private void validateCarNameLength(String carName) {
        if(carName.length()>MAX_NAME_LENGTH_RANGE){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }



}

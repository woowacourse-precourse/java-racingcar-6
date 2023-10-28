package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class CarName {
    private List<String> carList;

    public void setCarName(String carNames){
        validateNull(carNames);
        List<String> carList  = Arrays.asList(carNames.split(","));
        validateCarName(carList);
        this.carList = carList;
    }
    public List<String> getCarName(){
        return this.carList;
    }
    public static void validateCarName(List<String> carList){
        validateLength(carList);
        validateType(carList);
        validateDuplicate(carList);
    }
    public static void validateLength(List<String> carList){
        for(String carName : carList){
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateType(List<String> carList){
        for(String carName : carList){
            if(!Pattern.matches("^[a-zA-Z]*$", carName)){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateDuplicate(List<String> carList){
        List<String> tmp = carList;
        if(tmp.stream().distinct().count()!=carList.size()){
            throw new IllegalArgumentException();
        }
    }
    public static void validateNull(String carNames){
        if(carNames.equals("")){
            throw new IllegalArgumentException();
        }
    }
}

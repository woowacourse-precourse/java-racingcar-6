package racingcar;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarFactory {
    
    public void createCar(){

    }

    public List<String> stringtoListByComma(String name){
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }

    public void hasDuplicatedName(){

    }
}

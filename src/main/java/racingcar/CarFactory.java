package racingcar;

import java.util.Collections;
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

    public boolean hasDuplicatedName(List<String> names){
        if(countDistinctListSize(names)!=names.size()){
            return true;
        }
        return false;
    }

    public Long countDistinctListSize(List<String> list){
        return list.stream().distinct().count();
    }
}

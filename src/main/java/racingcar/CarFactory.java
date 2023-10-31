package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarFactory {
    
    public List<Car> createCar(){
        String nameString = IoManager.readLine();
        List<String> nameList = stringtoListByComma(nameString);
        checkDuplicatedName(nameList);
        List<Car> cars = new ArrayList<Car>();
        for(String name:nameList){
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<String> stringtoListByComma(String name){
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }

    public void checkDuplicatedName(List<String> names){
        if(countDistinctListSize(names)!=names.size()){
            throw new IllegalArgumentException("중복된 이름");
        }
    }

    public Long countDistinctListSize(List<String> list){
        return list.stream().distinct().count();
    }
}

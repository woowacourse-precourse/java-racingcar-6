package racingcar.domain;

import racingcar.IoManager;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarFactory {
    
    public List<Car> createCar(){
        IoManager.printEnterCarName();
        String nameString = IoManager.readLine();
        List<String> nameList = stringtoListByComma(nameString);
        checkDuplicatedName(nameList);
        return createCarList(nameList);
    }

    private List<Car> createCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
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

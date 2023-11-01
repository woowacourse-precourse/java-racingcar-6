package racingcar.domain;

import racingcar.errormessage.InputError;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateEmptyList(cars);
        validateNameLength(cars);
        validateDuplicateName(cars);
        this.cars = cars;
    }

    private void validateEmptyList(List<Car> cars){
        if(cars.size()==0) throw new IllegalArgumentException(InputError.INPUT_EMPTY_ERROR_MESSAGE);
    }

    private void validateNameLength(List<Car> cars){
        for(int i=0;i<cars.size();++i){
            if(cars.get(i).getName().length()>5) throw new IllegalArgumentException(InputError.INPUT_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateName(List<Car> cars){
        Set<String> nameSet = new HashSet<>();
        for(int i=0;i<cars.size();++i){
            if(nameSet.contains(cars.get(i).getName())) throw new IllegalArgumentException(InputError.INPUT_DUPLICATE_NAME_ERROR_MESSAGE);
            nameSet.add(cars.get(i).getName());
        }
    }

}

package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static racingcar.validator.InputValidation.*;

public class RacingCarList{
    private List<RacingCar> car;
    private final static String SEPARATE_REGEX = ",";

    public RacingCarList(String inputs) {
        car = new ArrayList<>();
        splitByComma(inputs);
    }
    public RacingCarList(){
        car = new ArrayList<>();
    }

    private void splitByComma(String inputs) {
        String[] names = inputs.split(SEPARATE_REGEX);
        for (String name : names) {
            validNameFormat(name);
            validNameLength(name);
            this.car.add(new RacingCar(name));
        }
    }

    public int size() {
        return this.car.size();
    }

    public void add(RacingCar car){
        this.car.add(car);
    }

    public void clear(){
        this.car.clear();
    }

    public Stream<RacingCar> stream(){
        return this.car.stream();
    }
    public RacingCar getCar(int index) {
        return this.car.get(index);
    }
}

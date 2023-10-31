package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private final List<Car> cars;
    private final int times;

    public Player(List<Car> cars, int times){
        validateTime(times);
        this.cars = cars;
        this.times = times;
    }
    public Player(String names, String times){
        this.cars = convertStringToListCars(names);
        this.times = stringToInteger(times);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }

    private List<Car> convertStringToListCars(String names){
        return createCarList(splitNames(names));
    }

    public List<String> splitNames(String names){
        return Arrays.asList(names.split(","));
    }

    public List<Car> createCarList(List<String> cars){
        List<Car> result = new ArrayList<>();
        for (String name : cars) {
            Car car = new Car(name);
            validateCarName(name);
            result.add(car);
        }

        validateCarDuplicate(result);
        return result;
    }

    public int stringToInteger(String str){
        return Integer.parseInt(str);
    }


    private void validateTime(int times){
        if (times<=0) {
            throw new IllegalArgumentException("[ERROR] Times should be more than 0.");
        }
    }

    public void validateCarName(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] The name must not be more than 5 characters.");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("[ERROR] There is no name.");
        }
    }

    private void validateCarDuplicate(List<Car> cars){
        List<String> names = new ArrayList<>();
        for(Car car : cars){
            names.add(car.getName());
        }
        if(names.size() != names.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] Cars' names shouldn't be same.");
        }
    }

}

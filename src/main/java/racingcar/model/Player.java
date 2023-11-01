package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String REGEX = "^[a-zA-Z]*$";

    private final List<Car> cars;
    private final int times;

    public Player(String cars, String times){
        this.cars = convertStringToListCars(cars);
        this.times = stringToInteger(times);
        validateTime(this.times);
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

    private List<String> splitNames(String names){
        return Arrays.asList(names.split(","));
    }

    private List<Car> createCarList(List<String> cars){
        List<Car> result = new ArrayList<>();
        for (String name : cars) {
            Car car = new Car(name);
            validateCarName(name);
            result.add(car);
        }

        validateCarDuplicate(result);
        return result;
    }

    private int stringToInteger(String str){
        return Integer.parseInt(str);
    }

    private void validateTime(int times){
        if (times<=0) {
            throw new IllegalArgumentException("[ERROR] Times should be more than 0.");
        }
    }

    private void validateCarName(String name){
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] The name must not be more than 5 characters.");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("[ERROR] Car's name shouldn't be null.");
        }
        if(!Pattern.matches(REGEX,name)){
            throw new IllegalArgumentException("[ERROR] Car's name should have only english character.");
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

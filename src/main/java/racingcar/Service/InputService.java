package racingcar.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Domain.Car;


public class InputService {
    String inputCarname;
    ArrayList<String> CarNames = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    String inputTryNum;

    public ArrayList<Car> getCars() {
        return cars;
    }

    public List<String> SplitCarname(String inputCarname) {
        CarNames = new ArrayList<>(Arrays.asList(inputCarname.split(",")));
        return CarNames;
    }


    public String inputCarname(String name) {
        this.inputCarname = name;
        return inputCarname;
    }

    public List<String> getCarNames() {
        return CarNames;
    }

    public boolean valideFivename(String name) {
        CarNames = (ArrayList<String>) SplitCarname(name);
        return CarNames.stream().noneMatch(this::isNameOverFiveChars);
    }

    private boolean isNameOverFiveChars(String name) {
        return name.length() > 5;
    }

    public String inputTryNum(String tryNum) {
       return this.inputTryNum=tryNum;

    }

    public void throwException(String input) {
        if (!valideFivename(input)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 입력해 주세요");
        }

    }

    public List<Car> makeCarArray() {
        for (int i = 0; i < this.CarNames.size(); i++) {
            Car car = new Car();
            car.setName(CarNames.get(i));
            cars.add(car);
        }
        return cars;
    }
}
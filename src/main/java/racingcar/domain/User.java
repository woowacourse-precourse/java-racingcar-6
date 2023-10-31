package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_CAR_NUMBER = 2;

    public List<Car> nameForCar(String names) {
        List<String> carsName = separateNames(names);
        List<Car> cars = new ArrayList<>();
        carsName.stream().forEach(name -> cars.add(new Car(name.trim())));
        return cars;
    }

    public boolean validateName(String name) {
        return name.length() <= MAX_NAME_SIZE;
    }

    public List<String> separateNames(String names) {
        String[] temp = names.split(",");
        validateCarCount(names,temp);
        validateGame(temp);
        List<String> cars = new ArrayList<>(Arrays.asList(temp));
        return cars;
    }

    public void validateGame(String[] cars) {
        if (cars.length < MIN_CAR_NUMBER) {
            throw new IllegalArgumentException("게임을 진행하기 위한 자동차의 개수는 최소 2대 입니다.");
        }
    }

    public void validateCarCount(String names,String[] cars){
        if(cars.length<=countComas(names)){
            throw new IllegalArgumentException("자동차의 이름은 공백이 불가능합니다.");
        }
    }

    public long countComas(String names){
        return names.chars()
                .filter(c->c==',')
                .count();
    }
}

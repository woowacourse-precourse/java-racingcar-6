package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGameModel {

    public static final double FOUR = 4;

    // 8. 값이 4이상인지 확인하는 기능
    public boolean isSameOrBiggerThanFour(int number){
        if(number >= FOUR){
            return true;
        } else {
            return false;
        }
    }

    // 입력받은 자동차의 이름들을 List<Car>로 바꿔서 return하는 메서드
    public List<Car> stringToList(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNameArray) {
            cars.add(new Car(name));
        }

        return cars;
    }


}

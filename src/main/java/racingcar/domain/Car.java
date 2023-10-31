package racingcar.domain;

import java.util.List;

public class Car {
    public Boolean numberOfCharacters(String carName){
        return "자동차이름이 모두 5자 이하 = true";
    }
    public void splitCarName(String cars){
        String[] car = cars.split(",");
    }
}
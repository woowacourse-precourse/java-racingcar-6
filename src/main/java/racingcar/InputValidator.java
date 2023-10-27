package racingcar;

import java.util.List;

public class InputValidator {
    public void checkNameLength(List<String> cars){
        for(int i = 0; i < cars.size(); i++){
            String car = cars.get(i);
            if(car.length() > 5) throw new IllegalArgumentException();
        }
    }
}

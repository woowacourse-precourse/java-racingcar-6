package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Race {
    StopOrGo stopOrGo = new StopOrGo();
    GenerateRandomNum randomNum = new GenerateRandomNum();
    View view = new View();

    public void race(List<Car> cars, HashMap<String, Integer> racing){
        cars.forEach(car -> {
            if(stopOrGo.move(randomNum.createRandomNum())){
                car.move();
            }
            String name = car.getName();
            int position = car.getPosition();
            racing.put(name, position);
            view.viewResult(name, position);
        });
    }
}

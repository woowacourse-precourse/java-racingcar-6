package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    Setting setting;
    List<Car> cars;

    public Racing(Setting setting){
        this.setting = setting;
    }

    public void play(){
        cars = setting.getCars();
        int carNumber = cars.size();

    }
}
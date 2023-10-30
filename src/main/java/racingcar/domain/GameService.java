package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Navigation navigation;

    public void init(ArrayList<Car> carList) {
        navigation=new Navigation(carList);
    }

    public void doRacing() {
        navigation.moveAll();
    }

    public List<Car> getStatus() {
        return navigation.getList();
    }
}

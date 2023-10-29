package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<Car> saveCarsInfo(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++){
            String name = carNames[i];
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public void saveRoundResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) cars.get(i).setPosition(cars.get(i).getPosition() + 1);
            }
    }

}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public List<String> raceSituation = new ArrayList<>();

    public void createRace(List<String> carNames) {

        for(String carName : carNames){
            raceSituation.add(carName+" : ");
        }
    }


}

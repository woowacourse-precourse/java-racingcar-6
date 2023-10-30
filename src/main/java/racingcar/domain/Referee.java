package racingcar.domain;

import java.util.List;

public class Referee{

    public List<String> determineWinners(Cars cars){
        return cars.getMaxForwardCountCarNames();
    }

    public void announceWinners(Cars cars){

    }

}

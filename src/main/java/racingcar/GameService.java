package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Cars cars;

    public Cars makeCars(String carNames){
        cars = new Cars(carNames);
        return cars;
    }

    public List<RoundResult> forwardStart(int round){
        List<RoundResult> roundResults = new ArrayList<>();
        for(int i=0; i<round; i++){
            cars.moveForward();
            roundResults.add(new RoundResult(cars.saveRecord()));
        }
        return roundResults;
    }

    public List<String> selectWinners(){
        return cars.pickWinnersName();
    }

}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private List<Integer> carRandomNumbers;
    public List<Integer> getRandomNumbers(){
        return this.carRandomNumbers;
    }
    private List<Integer> setRandomNums(int numOfCar){
        carRandomNumbers = new ArrayList<>();
        for(int i=0; i<numOfCar; i++) {
            carRandomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
        return carRandomNumbers;
    }

}

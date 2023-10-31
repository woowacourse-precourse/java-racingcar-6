package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {
    private List<Integer> carRandomNumbers;

    private void setRandomNums(int numOfCar){
        for(int i=0; i<numOfCar; i++) {
            carRandomNumbers.add(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Integer> getRandomNumbers(){
        return carRandomNumbers;
    }

}

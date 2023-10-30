package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.model.Constants.*;


public class RandomNumber {
    private List<Integer> RandomNumberList;

    public RandomNumber(Integer carNums) {
        setRandomNumberList(carNums);
    }

    private void setRandomNumberList(Integer carNums) {
        RandomNumberList = new ArrayList<>();
        while (RandomNumberList.size() < carNums) {
            RandomNumberList.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
    }

    public List<Integer> getRandomNumberList(){ return RandomNumberList; }

}

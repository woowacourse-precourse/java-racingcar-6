package racingcar.racingmanager;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class HandleNumber {

    public List<Integer> generateRandomNumberList(int countOfNumbers){
        List<Integer> randomNumbers = new ArrayList<>();

        for(int i = 0; i < countOfNumbers; i++){
            randomNumbers.add(Randoms.pickNumberInRange(0,9));
        }
        return randomNumbers;
    }

}

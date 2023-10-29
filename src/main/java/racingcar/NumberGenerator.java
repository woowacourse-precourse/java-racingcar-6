package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> createRandomNumbers(int n){
        List<Integer> numberList =  new ArrayList<>();

        while(numberList.size() < n){
            int number = Randoms.pickNumberInRange(0, 9);

            numberList.add(number);
        }

        return numberList;
    }
}

package racingmanager;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class HandleNumber {

    public List<Integer> generateRandomNumberList(int countOfNumbers){
        List<Integer> randArrList = new ArrayList<>();

        for(int i = 0; i < countOfNumbers; i++){
            randArrList.add(Randoms.pickNumberInRange(0,9));
        }

        return randArrList;
    }

}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<String> resultList = new ArrayList<>();


    private RacingGame() {

    }

    public void initResultList(List resultList) {
        List<String> cars = Inputs.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            resultList.add("");
        }
    }

    public void move(List cars) {
        int randNum;
        for (int i=0; i<cars.size(); i++) {
            randNum = Randoms.pickNumberInRange(0,9);
            if(randNum >= 4) {
                resultList.set(i, resultList.get(i)+"-");
            }
        }

    }




}

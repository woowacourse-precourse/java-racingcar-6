package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<String> resultList = new ArrayList<>();
    private List<String> winner = new ArrayList<>();

    private RacingGame() {

    }

    public void initResultList(List resultList) {
        List<String> cars = Inputs.getCars();
        for (int i = 0 ; i < cars.size() ; i++) {
            resultList.add("");
        }
    }



}

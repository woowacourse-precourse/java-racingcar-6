package racingcar.Service;

import racingcar.Model.Cars;
import racingcar.Util.RandomAdvanceOrstop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JudgeWinnerResult {
    Cars cars = new Cars();

    public String judgeWinner(){
        List<String> winnerList = new ArrayList<String>();

        String[] WinnerList = new String[5];
        return String.join(", ",winnerList);
    }

}

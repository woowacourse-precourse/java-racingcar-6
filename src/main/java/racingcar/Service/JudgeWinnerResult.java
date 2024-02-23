package racingcar.Service;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;

public class JudgeWinnerResult {
    Car cars = new Car();

    public String judgeWinner(){
        List<String> winnerList = new ArrayList<String>();

        String[] WinnerList = new String[5];
        return String.join(", ",winnerList);
    }

}

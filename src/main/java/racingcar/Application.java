package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public List<String> carNamesList = new ArrayList<>();
    public List<Integer> randomNumbers = new ArrayList<>();
    public List<Integer> scoreList = new ArrayList<>();




    public void displayResult() {
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println(carNamesList.get(i) + " : " + "-".repeat(scoreList.get(i)));
        }
        System.out.println();
    }



}


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

    public void roundResult() {
        for (int i = 0; i < scoreList.size(); i++) {
            int randomNumber;
            if (randomNumbers.size() > i) {
                randomNumber = randomNumbers.get(i);
            } else {
                randomNumber = Randoms.pickNumberInRange(0, 9);
            }
            if (randomNumber >= 4) {
                scoreList.set(i, scoreList.get(i) + 1);
            }
        }
    }

}


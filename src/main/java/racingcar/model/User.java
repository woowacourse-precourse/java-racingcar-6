package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class User {

    private List<String> userInputCarNames;
    private int userInputTryCount;

    public User() {
    }

    public List<String> inputCarNames() {
        InputView.inputCarName();
        String carNames = Console.readLine();
        String[] carNamesSplit = carNames.split(",");
        userInputCarNames = Arrays.asList(carNamesSplit);
        exceed5Digits();
        return userInputCarNames;
    }

    public void exceed5Digits() {
        for(String carName : userInputCarNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

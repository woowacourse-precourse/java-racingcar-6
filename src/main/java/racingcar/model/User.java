package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class User {

    public User() {
    }

    public List<String> inputCarNames() {
        InputView.inputCarName();
        String carNames = Console.readLine();
        String[] carNamesSplit = carNames.split(",");
        List<String> carNamesList = Arrays.asList(carNamesSplit);
        exceed5Digits(carNamesList);
        return carNamesList;
    }

    public void exceed5Digits(List<String> userInputCarNames) {
        for(String carName : userInputCarNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("차 이름이 5자를 초과하였습니다.");
            }
        }
    }
}

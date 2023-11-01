package racingcar.logic;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    static final int Go = 1;
    static final int None = 0;
    public CarRacingGame() {

    }

    public void play() {
        List<String> carNameList = Arrays.asList(InputView.inputCarName().split(","));
        List<Integer> carGoNumberList;
        Integer tryNumber = Integer.parseInt(InputView.inputTryNumber());
        carGoNumberList = new ArrayList<>(carNameList.size());

        for (int i = 0; i < carNameList.size(); i++) {
            carGoNumberList.add(0);
        }

        OutputView.printResult();
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < carNameList.size(); j++) {
                int number = Randoms.pickNumberInRange(0, 9);
                if (number >= 4) {
                    carGoNumberList.set(j, carGoNumberList.get(j) + 1);
                }
            }
            for (int carIndex = 0; carIndex < carNameList.size(); carIndex++) {
                OutputView.printResultDetail(carNameList.get(carIndex), carGoNumberList.get(carIndex));
            }
            OutputView.printLineBreaking();
        }


    }
}

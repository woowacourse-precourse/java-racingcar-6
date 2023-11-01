package racingcar.logic;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class CarRacingGame {
    static final int Go = 1;
    static final int None = 0;

    private List<String> carNameList;
    private List<Integer> carGoNumberList;
    private Integer tryNumber;

    public CarRacingGame() {
        carGoNumberList = new ArrayList<>();
    }

    public void play() {
        inputCarNames();
        validateCarNames();
        inputTryNumber();
        initCarGoNumberList();

        OutputView.printResult();
        playRacingGame();
        printWinner();
    }

    private void inputCarNames() {
        carNameList = Arrays.asList(InputView.inputCarNames().split(","));
    }

    private void validateCarNames() {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    private void inputTryNumber() {
        tryNumber = Integer.parseInt(InputView.inputTryNumber());
    }

    private void initCarGoNumberList() {
        for (int i = 0; i < carNameList.size(); i++) {
            carGoNumberList.add(0);
        }
    }

    private void playRacingGame() {
        for (int i = 0; i < tryNumber; i++) {
            playOneRound();
            printRoundResult();
        }
    }

    private void playOneRound() {
        for (int j = 0; j < carNameList.size(); j++) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                carGoNumberList.set(j, carGoNumberList.get(j) + 1);
            }
        }
    }

    private void printRoundResult() {
        for (int carIndex = 0; carIndex < carNameList.size(); carIndex++) {
            OutputView.printResultDetail(carNameList.get(carIndex), carGoNumberList.get(carIndex));
        }
        OutputView.printLineBreaking();
    }

    private void printWinner() {
        int max = Collections.max(carGoNumberList);
        ArrayList<Integer> maxIndexList = new ArrayList<>();

        for (int i = 0; i < carGoNumberList.size(); i++) {
            int currentNumber = carGoNumberList.get(i);
            if (currentNumber == max) { // 현재 숫자가 최댓값과 같은 경우, 인덱스 리스트에 추가합니다.
                maxIndexList.add(i);
            }
        }
        OutputView.printWinner(maxIndexList, carNameList);
    }
}


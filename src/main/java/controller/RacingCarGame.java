package controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import model.Car;
import model.TryCount;
import util.CarNameValidation;
import util.TryCountValidation;
import view.InputView;
import view.OutputView;

public class RacingCarGame {
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int CAN_MOVE_NUMBER = 4;
    static ArrayList<Car> carNameList;
    static TryCount tryCount;
    static String[] carMoveCount;
    private static InputView inputView;
    private static OutputView outputView;


    public RacingCarGame() {
        inputView = new InputView();
        outputView = new OutputView();
        carNameList = new ArrayList<>();

    }

    public void start() {
        outputView.printStartGame();
        setCarNames(inputView.inputCarName());
        outputView.printInputTryCount();
        setTryCount(inputView.inputTryCount());
        initCarMoveCount();

        outputView.printResultTry();
        for (int tc = 0; tc < tryCount.getTryCount(); tc++) {
            setRandomNumber();
            printResult();
        }
        ResultGame();

    }

    private void ResultGame() {
        StringBuilder sb = new StringBuilder();
        sb.append(findWinner(findMaxPoint()));
        outputView.printResultGame(sb);
    }

    private int findMaxPoint() {
        int maxPoint = 0;
        for (String moveCount : carMoveCount) {
            if (moveCount.length() > maxPoint) {
                maxPoint = moveCount.length();
            }
        }
        return maxPoint;
    }

    private String findWinner(int maxPoint) {
        String winner = "";
        for (int i = 0; i < carMoveCount.length; i++) {
            if (carMoveCount[i].length() == maxPoint) {
                winner += carNameList.get(i).getCarName() + ", ";
            }
        }
        winner = winner.substring(0, winner.length() - 2);
        return winner;
    }

    private void initCarMoveCount() {
        carMoveCount = new String[carNameList.size()];
        for (int i = 0; i < carMoveCount.length; i++) {
            carMoveCount[i] = "";
        }
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carNameList.size(); i++) {
            sb.append(carNameList.get(i).getCarName() + " : " + carMoveCount[i] + "\n");
        }
        outputView.printMoveResult(sb);
    }

    private void setRandomNumber() {
        for (int i = 0; i < carNameList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
            isMove(randomNumber, i);
        }
    }

    private void isMove(int randomNumber, int carNumber) {
        if (randomNumber >= CAN_MOVE_NUMBER) {
            carMoveCount[carNumber] += "-";
        }
    }

    private void setCarNames(String[] carNames) {
        CarNameValidation.checkCarNameValidation(carNames);
        for (int i = 0; i < carNames.length; i++) {
            carNameList.add(new Car(carNames[i]));
        }
    }

    private void setTryCount(String tryCount) {
        TryCountValidation.checkTryCountValidation(tryCount);
        RacingCarGame.tryCount = new TryCount(Integer.parseInt(tryCount));
    }


}

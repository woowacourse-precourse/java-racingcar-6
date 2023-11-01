package racingcar.controller;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import racingcar.model.CarNameList;
import racingcar.model.ResultList;
import racingcar.view.View;

public class RacingGameController {
    private static CarNameList carNameList;
    private static ResultList resultList;
    private static Integer tryNumber;
    private static View view;
    private final int CHECK_FORWARD = 4;

    private final String REGEX_DIGIT = "^[\\d]*$";

    private final String DELIMETER = ",";
    private final String MOVING_FORWARD_STRING = "-";
    private final String INITIALIZED_RESULT_STRING = "";
    private final int RANDOM_START_NUMBER = 0;
    private final int RANDOM_END_NUMBER = 9;

    public void init() {
        view = new View();
        view.initView();
        carNameList = new CarNameList(getCarString());
        carNameList.NameSizeExceededCheck();
        carNameList.NameValueCheck();
        view.tryNumberView();
        tryNumber = getTryNumber();
        resultList = new ResultList(getResultList());
        PlayingGame();
    }

    public void PlayingGame() {
        view.resultView();
        for (int i = 0; i < tryNumber; i++) {
            MovingCar();
        }
        getWinner();
    }

    public void MovingCar() {
        List<String> result = resultList.getResultList();
        for (int i = 0; i < result.size(); i++) {
            MovingForward(i, result);
        }
        view.resultViewperIter(carNameList.getCarNameList(), resultList.getResultList());
    }

    public void MovingForward(int idx, List<String> result) {
        if (Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER) >= CHECK_FORWARD) {
            result.set(idx, result.get(idx) + MOVING_FORWARD_STRING);
        }
    }

    public String[] getCarString() {
        String carName = Console.readLine();
        return carName.split(DELIMETER);
    }

    public Integer getTryNumber() {
        String inputTryNumber = Console.readLine();
        checkTryNumber(inputTryNumber);
        Integer inputNumber = parseInt(inputTryNumber);
        return inputNumber;
    }

    public ThrowingCallable checkTryNumber(String inputTryNumber){
        if(checkNumberInRegex(inputTryNumber)) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    public boolean checkNumberInRegex(String inputTryNumber){
        return !Pattern.matches(REGEX_DIGIT, inputTryNumber);
    }

    public List<String> getResultList() {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < carNameList.getCarCount(); i++) {
            resultList.add(INITIALIZED_RESULT_STRING);
        }
        return resultList;
    }

    public void getWinner() {
        int checkWinner = getMaxForward();
        List<String> result = resultList.getResultList();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() == checkWinner) {
                winners.add(carNameList.getCarNameList()[i]);
            }
        }
        view.winnerView(winners);
    }

    public int getMaxForward() {
        int maxForwardNumber = 0;
        for (String s : resultList.getResultList()) {
            maxForwardNumber = max(maxForwardNumber, s.length());
        }
        return maxForwardNumber;
    }
}

package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class User {
    public List<String> inputCar() {
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        checkLastComma(input);
        checkInputCarName(carNames);
        return carNames;
    }

    public void checkLastComma(String input){
        boolean endsWithComma = input.endsWith(",");
        if(endsWithComma){
            throw new IllegalArgumentException();
        }
    }

    public void checkInputCarName(List<String> carNames) {
        checkDuplicateName(carNames);
        for (String carName : carNames) {
            checkLengthName(carName);
            checkSpaceInName(carName);
        }
    }

    public void checkLengthName(String carName){
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException();
        }
    }

    public void checkSpaceInName(String carName) {
        if (carName == null || carName.contains(" ") || carName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicateName(List<String> carNames) {
        HashSet<String> duplicateName = new HashSet<>();
        duplicateName.addAll(carNames);
        if (carNames.size() != duplicateName.size()) {
            throw new IllegalArgumentException();
        }
    }


    public int inputTryNumber() {
        String input = Console.readLine();
        int tryNumber = checkTryNumber(input);
        checkNegativeNumber(tryNumber);
        return tryNumber;
    }

    public int checkTryNumber(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하였습니다.");
        }
        return inputNumber;
    }

    public void checkNegativeNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
    }
}

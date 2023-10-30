package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    public List<String> carName = new ArrayList<String>();
    public List<Integer> movementSoFar = new ArrayList<Integer>();
    //NumberOfTries numberOfTries;
    Integer numberOfTries;

    //    public RacingCarGame() {
//        this.numberOfTries = new NumberOfTries();
//    }
    public void changeLine() {
        System.out.println();
    }

    public String inputString(String inputText) {
        System.out.println(inputText);
        String inputStr = Console.readLine();
        return inputStr;
    }

    public void stringToList(String strCarName) {
        if (strCarName.contains(",")) {
            carName = Arrays.asList(strCarName.split(","));
        } else if (!strCarName.contains(",")) {
            carName = Arrays.asList(strCarName);
        }
    }

    public void carName() {
        String strCarName = inputString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 자동차 이름 입력 완료
        stringToList(strCarName);
        setMovement();
//        System.out.println(carName);
//        System.out.println(movementSoFar);
    }

    public void setMovement() {
        for (int i = 0; i < carName.size(); i++) {
            movementSoFar.add(0);
        }
    }

    public void numberOfTries() {
        String strTries = inputString("시도할 회수는 몇회인가요?");
        isNotInteger(strTries);
        lessThenZero(strTries);
        numberOfTries = Integer.parseInt(strTries);
    }

    public void isNotInteger(String strTries) throws IllegalArgumentException {
        try {
            Integer.parseInt(strTries);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("정수를 입력하지 않아서 프로그램을 종료합니다.");
        }
    }

    public void lessThenZero(String strTries) throws IllegalArgumentException {
        if (Integer.parseInt(strTries) < 0) {
            throw new IllegalArgumentException("횟수는 음수가 될 수 없으므로 프로그램을 종료합니다");
        }
    }

    public Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean move() {
        Integer randomNumber = generateRandomNumber();
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void updateMovement(Integer indexOfCarName) {
        if (move()) {
            movementSoFar.set(indexOfCarName, (movementSoFar.get(indexOfCarName) + 1));
        }
    }

    public String getDash(Integer indexOfCarName) {
        String getDash = "";
        for (int i = 0; i < movementSoFar.get(indexOfCarName); i++) {
            getDash += "-";
        }
        return getDash;
    }

    public void printMovement(Integer indexOfCarName) {
        System.out.printf("%s : %s%n", carName.get(indexOfCarName), getDash(indexOfCarName));
    }
}
package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;


public class RacingCarGame {
    CarService carService = new CarService();
    String carName = "";
    String inputStr = "";

    public void playGame() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        inputStr = Console.readLine();
        if(isInvalidValue(inputStr)) {
            throw new IllegalArgumentException("각 자동차 이름의 길이가 5글자 미만으로 ,로 구분해 작성해주세요.");
        }
        carName = inputStr;
        List<Car> carList = carService.createCar(carName);

        System.out.println("시도할 회수는 몇회인가요?");

        inputStr = Console.readLine();
        if(!isNumber(inputStr)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        System.out.println("실행 결과");
        int attemptNum = Integer.parseInt(inputStr);

        displayGameProgress(attemptNum, carList);
        displayWinnerCar(carList);
    }

    public void displayGameProgress(int attemptNum, List<Car> carList) {
        for(int i = 0; i < attemptNum; i++) {
            carService.moveForwards(carList);
            carService.displayPositions(carList);
            System.out.println();
        }
    }

    public List<String> findWinnerCar(List<Car> carList) {
        int winCarPosition = -1;
        List<String> carNameList = new ArrayList<>();
        for (Car car : carList) {
            if(car.getPosition() > winCarPosition) {
                winCarPosition = car.getPosition();
                carNameList.clear();
                carNameList.add(car.getName());
                continue;
            }
            if (car.getPosition() == winCarPosition) {
                winCarPosition = car.getPosition();
                carNameList.add(car.getName());
            }
        }
        return carNameList;
    }

    public void displayWinnerCar(List<Car> carList) {
        List<String> carNameList = findWinnerCar(carList);
        String winCarName = carNameList.get(0);
        for (int i = 1; i < carNameList.size(); i++) {
            winCarName += ", " + carNameList.get(1);
        }
        System.out.println("최종 우승자 : " + winCarName);
    }

    private boolean isInvalidValue (String inputStr) {
        return inputStr == null ||
                inputStr == "" ||
                isTooLongString(inputStr) ||
                hasSameName(inputStr) ||
                hasSpace(inputStr);
    }
    private boolean isTooLongString (String inputStr) {
        String[] inputStringArray = inputStr.split(",");
        for(String str : inputStringArray) {
            if (str.length() > 5) return true;
        }
        return false;
    }
    private boolean hasSameName (String inputStr) {
        String[] inputStringArray = inputStr.split(",");
        Set<String> nameSet = new HashSet<>(Arrays.asList(inputStringArray));

        if(nameSet.size() != inputStringArray.length) return true;
        return false;
    }

    private boolean hasSpace (String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        for (char input: inputArr) {
            if (input == ' ') return true;
        }
        return false;
    }

    private boolean isNumber(String inputStr) {
        return inputStr != null && inputStr.matches("[0-9]+");
    }
}

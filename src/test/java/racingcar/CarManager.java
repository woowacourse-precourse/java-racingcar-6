package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CarManager {
    String[] carArray;
    int moveCount;
    int carMoveCount;
    public void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        inputForCarName();
    }

    public String[] inputForCarName() {
        String carStr = Console.readLine();
        carArray = carStr.split(",");
        carNameValidationCheck(carArray);
        return carArray;
    }

    public void printCarMovePrompt() {
        System.out.println("시도할 횟수는 몇회인가요?");
        inputForCarMove();
    }

    public int inputForCarMove() {
        String carMove = Console.readLine();
        carMoveValidationCheck(carMove);
        moveCount = Integer.parseInt(carMove);
        return moveCount;
    }

    public void carNameValidationCheck(String[] carArray) {
        for (String car : carArray) {
            if (car == null || car.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public void carMoveValidationCheck(String carMove) {
        int number = Integer.parseInt(carMove);
        if (number <= 0) {
            throw new IllegalArgumentException("입력하신 값이 0보다 작거나 같습니다.");
        }
    }
}
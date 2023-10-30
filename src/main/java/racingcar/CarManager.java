package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class CarManager {
    Validation validation = new Validation();
    String[] carArray;
    int moveCount;
    public void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public String[] inputForCarName() {
        String carStr = Console.readLine();
        carArray = carStr.split(",");
        validation.carNameValidationCheck(carArray);
        return carArray;
    }

    public void printCarMovePrompt() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public int inputForCarMove() {
        String carMove = Console.readLine();
        validation.carMoveValidationCheck(carMove);
        moveCount = Integer.parseInt(carMove);
        return moveCount;
    }
}
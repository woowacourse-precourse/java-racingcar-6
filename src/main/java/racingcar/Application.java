package racingcar;

import racingcar.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int inputValidation(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid input");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameController.setUp(Console.readLine());
        System.out.println("시도할 회수는 몇회인가요?");
        gameController.startGame(inputValidation(Console.readLine()));
        gameController.printFinalists();
    }
}

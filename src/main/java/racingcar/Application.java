package racingcar;

import racingcar.controller.GameController;
import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constant;

public class Application {

    public static int inputValidation(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Constant.ERROR_NUMBER_OF_ATTEMPT_MESSAGE);
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        System.out.println(Constant.INPUT_CAR_NAME_MESSAGE);
        gameController.setUp(Console.readLine());

        System.out.println(Constant.INPUT_NUMBER_OF_ATTEMPT_MESSAGE);
        gameController.startGame(inputValidation(Console.readLine()));

        gameController.printFinalists();
    }
}

package racingcar.View;

import racingcar.Service.UserInput;

public class OutputView {   //최종 결과 출력

    UserInput userInput = new UserInput();
    public void printWinnerResult(int tryNumber) throws IllegalAccessException {
        for (int i = 0; i < tryNumber; i++) {

        }
        System.out.println();
    }


    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
    }



   
}

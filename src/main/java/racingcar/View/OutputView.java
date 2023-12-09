package racingcar.View;

import racingcar.Model.Car;
import racingcar.Service.UserInputCarName;
import racingcar.Service.UserInputTryNumber;

public class OutputView {   //최종 결과 출력

    UserInputTryNumber userInputTryNumber = new UserInputTryNumber();
    public void printWinnerResult() throws IllegalAccessException {
        for (int i = 0; i < car.tryNumber; i++) {

        }
        System.out.println();
    }


    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
    }




}

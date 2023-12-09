package racingcar.Service;

import racingcar.Model.Car;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Infomation.ErrorInfomation.TRY_NUMBER_COUNT_ERROR_MESSAGE;
import static racingcar.Infomation.PrintInputMessage.printTryNumber;

public class UserInputTryNumber {   //사용자가 시도할 횟수를 입력
    Car car = new Car();
    public void userInputTryNumber() throws IllegalAccessException {
        try {
            printTryNumber(); //"시도할 횟수는 몇 회인가요?"
            car.tryNumber = Integer.parseInt(readLine());

            if (!judgeTryNumberLength()){
                throw new IllegalArgumentException(TRY_NUMBER_COUNT_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(car.tryNumber);
        }
    }

    private boolean judgeTryNumberLength() {
        return car.tryNumber >= 1 && car.tryNumber <= 9;
    }

}

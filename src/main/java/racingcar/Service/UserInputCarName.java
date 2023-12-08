package racingcar.Service;

import racingcar.Model.Car;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Infomation.ErrorInfomation.CAR_NAME_LIMIT_ERROR_MESSAGE;
import static racingcar.Infomation.NumberConstant.*;
import static racingcar.Infomation.PrintInputMessage.printInputCarName;

public class UserInput {    //사용자가 경주할 자동차 이름 입력 & 사용자가 시도할 횟수를 입력

    Car car = new Car();

    public void userInputCarName() {   //사용자가 경주할 자동차 이름 입력
        try {
            printInputCarName();  //"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
            car.setCarName(readLine());
            car.carList = car.getCarName().split(",");  //","으로 구분하여 입력
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CAR_NAME_LIMIT_ERROR_MESSAGE);   //"자동차 이름은 5글자를 넘길 수 없습니다."
        }

        judgeCarNameLength();
        System.out.println(car.carName);
    }

    public void judgeCarNameLength() throws IllegalAccessException{
        for (int i = 0; i < (car.carList).length; i++) {
            if ((car.carList[i]).length() > MAX_CAR_NAME_SIZE) {    //MAX_CAR_NAME_SIZE = 5;
                throw new IllegalArgumentException("[Error] 자동차 이름은 5글자 이하로 입력바랍니다.");
            }
        }
    }

    public void tryNumber()  {   //사용자가 시도할 횟수를 입력
        try {
            car.tryNumber = Integer.parseInt(readLine());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 정수만 입력바랍니다.");
        }
        System.out.println(car.tryNumber);
    }
}

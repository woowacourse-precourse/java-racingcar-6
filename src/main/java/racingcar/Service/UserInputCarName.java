package racingcar.Service;

import racingcar.Model.Car;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Infomation.ErrorInfomation.CAR_NAME_LIMIT_ERROR_MESSAGE;
import static racingcar.Infomation.NumberConstant.*;
import static racingcar.Infomation.PrintInputMessage.printInputCarName;

public class UserInputCarName {    //사용자가 경주할 자동차 이름 입력

    Car car = new Car();

    public void userInputCarName() throws IllegalAccessException {
        try {
            printInputCarName();  //"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
            car.setCarName(readLine());
            car.carList = car.getCarName().split(",");  //","으로 구분하여 입력

            if (!judgeCarNameLength()){
                throw new IllegalArgumentException(CAR_NAME_LIMIT_ERROR_MESSAGE);   //"자동차 이름은 5글자를 넘길 수 없습니다."
            }

        } catch (IllegalArgumentException e) {
            System.out.println(car.carName);
        }
    }

    private boolean judgeCarNameLength() {
        for (int i = 0; i < (car.carList).length; i++) {
            if ((car.carList[i]).length() > MAX_CAR_NAME_SIZE) {    //MAX_CAR_NAME_SIZE = 5;
                return false;
            }
        }
        return true;
    }
    /*
    private boolean judgeCarNameLength() {
    return List.of(car.carList).stream().allMatch(name -> name.length() <= MAX_CAR_NAME_SIZE);
    }
    위의 메소드를 이렇게 간결하게도 사용할 수 있음.
     */
}

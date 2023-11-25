package racingcar.Service;

import racingcar.Model.Car;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {    //사용자가 경주할 자동차 이름 입력 & 사용자가 시도할 횟수를 입력

    Car car = new Car();

    public void userInputCarName () throws IllegalAccessException{   //사용자가 경주할 자동차 이름 입력
        car.carName = readLine();
        car.carList = car.carName.split(",");  //","으로 구분하여 입력

        judgeCarNameLength();

        System.out.println(car.carName);
    }

    public void judgeCarNameLength() throws IllegalAccessException{
        for (int i = 0; i < (car.carList).length; i++) {
            if ((car.carList[i]).length() > 5) {
                throw new IllegalArgumentException("[Error] 자동차 이름은 5글자 이하로 입력바랍니다.");
            }
        }
    }

    public void tryNumber() throws IllegalAccessException {   //사용자가 시도할 횟수를 입력
        car.tryNumber = Integer.parseInt(readLine());
        if (car.tryNumber != ){
            throw new IllegalArgumentException("[Error] 정수만 입력바랍니다.");
        }
    }



}

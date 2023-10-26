package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CreateCar {
    //자동차 생성 클래스

    String[] getCarList(){
        String carNm = Console.readLine();
        String [] carList = carNm.split(",");
        return carList;
    }


}

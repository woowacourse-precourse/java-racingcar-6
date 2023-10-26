package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CreateCar {
    //자동차 생성 클래스

    public String[] getCarList(){
        String carNm = Console.readLine();
        String [] carList = carNm.split(",");
        ErrorOccur errorOccur = new ErrorOccur(carList);
        return errorOccur.returnCarList();
    }


}

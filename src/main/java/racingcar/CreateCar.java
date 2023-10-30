package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CreateCar {
    //자동차 생성 클래스
    private String name;
    private int move = 0;

    public CreateCar(String name){
        this.name = name;
    }

    public String ReturnCarName(){
        return name;
    }

    public int ReturnMove(){
        return move;
    }

//    public String[] getCarList(){
//        String carNm = Console.readLine();
//        String [] carList = carNm.split(",");
//        ErrorOccur errorOccur = new ErrorOccur(carList);
//        return errorOccur.returnCarList();
//    }


}

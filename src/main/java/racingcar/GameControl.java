package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameControl {
    //게임 진행 클래스
    public void Controller(String[] carNames,int trying){
        MoveCar moveCar = new MoveCar();
        Car[] cars = moveCar.CreateCar(carNames);
        System.out.println("");
        System.out.println("실행결과");
        int i = 0;
        while(i<trying){
            moveCar.PrintPosition(cars,moveCar);
            i+=1;
            System.out.println("");
        }
    }

}

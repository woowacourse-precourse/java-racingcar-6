package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static List<Car> carList = new ArrayList<>();

    public void updateCarList(List<String> carNameList){
        for (String name : carNameList){
            carList.add(new Car(name));
        }
    }

    private static boolean isMove(){
        return getRandomNumber() >= 4;
    }

    private static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void executingGame(List<Car> carList){
        for(Car car : carList){
            if(isMove()){
                car.updateStat();
            }
        }
    }



}

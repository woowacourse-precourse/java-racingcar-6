package racingcar;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {
    private final HashMap<String, Integer> racingMap;
    private final List<String> carList;

    CarRacing(List<String> carList) {
        this.racingMap = new HashMap<>();
        this.carList = carList;

        for (String car : carList) {
            this.racingMap.put(car, 0);
        }
    }

    private int setCarForwardNum(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isMoreFour(){
        return this.setCarForwardNum() >= 4;
    }

    public void setRacingMap(){
        for(String car: this.carList){
            if(!this.isMoreFour()) continue;

            int carNum = this.racingMap.get(car);
            this.racingMap.put(car, carNum + 1);
        }
    }

    public HashMap<String, Integer> getRacingMap(){
        return this.racingMap;
    }

    public void printRacingProgress(){
        for(String car: this.carList){
            System.out.print(car + " : ");
            this.printEachCarProgress(racingMap.get(car));
            System.out.println();
        }
        System.out.println();
    }

    private void printEachCarProgress(int num){
        for(int i = 0; i < num; i ++){
            System.out.print("-");
        }
    }
}

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

    public int setCarForwardingNum(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMoreFour(){
        return this.setCarForwardingNum() >= 4;
    }

    public void setRacingMap(){
        for(String car: this.carList){
            if(!this.isMoreFour()) continue;

            int carNum = this.racingMap.get(car);
            this.racingMap.put(car, carNum + 1);
        }
    }

    public void printRacingProgress(){
       for(String car: this.carList){
            System.out.print(car + " : ");
            this.printEachCarProgress(racingMap.get(car));
            System.out.println();
        }
       System.out.println();
    }

    public void printEachCarProgress(int num){
        for(int i = 0; i < num; i ++){
            System.out.print("-");
        }
    }

    public List<String> setRacingResult(){
        List<String> winnerList = new ArrayList<>();
        int maxNum = racingMap.get(carList.get(0));

        for(Entry<String, Integer> entry : racingMap.entrySet()){
            int entryNum = entry.getValue();

            if(entryNum > maxNum){
                maxNum = entryNum;
                winnerList.clear();
                winnerList.add(entry.getKey());
            }
            else if(entryNum == maxNum) {
                winnerList.add(entry.getKey());
            }
        }
        return winnerList;
    }

    public void printRacingResult(){
        List<String> winnerList = this.setRacingResult();

        System.out.print("최종 우승자 : ");
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winnerList) {
            joiner.add(winner);
        }
        System.out.println(joiner);
    }
}

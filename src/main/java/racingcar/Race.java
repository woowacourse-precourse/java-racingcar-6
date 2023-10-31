package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    public Map<String, Integer> CarsNameAndForwardTimes = new HashMap<>();

    public Race(List<String> Cars) {
        for (String car:Cars) {
            this.CarsNameAndForwardTimes.put(car, 0);
        }
        System.out.println("\n실행결과");
    }
    public void forwardInRace() {
        for (String key : this.CarsNameAndForwardTimes.keySet()) {
            if(canAdvance(Randoms.pickNumberInRange(0, 9))){
                int distance = this.CarsNameAndForwardTimes.get(key);
                this.CarsNameAndForwardTimes.put(key, distance + 1);
            }
        }
    }
    public boolean canAdvance(Integer randomNum){
        return randomNum>=4;
    }
    public void printAllCarAndAdvance(){
        for(String key: this.CarsNameAndForwardTimes.keySet()) {
            printCarAndAdvance(key);
        }
        System.out.println();
    }
    private void printCarAndAdvance(String key){
        System.out.print(key + " : ");
        if (this.CarsNameAndForwardTimes.get(key) == 0) {
            System.out.print("\n");
        } else {
            printDash(key);
        }
    }
    private void printDash(String key){
        for (int i = 0; i < this.CarsNameAndForwardTimes.get(key); i++) {
            if (i == this.CarsNameAndForwardTimes.get(key) - 1) System.out.println("-");
            else System.out.print("-");
        }
    }

}

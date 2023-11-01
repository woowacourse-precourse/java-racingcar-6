package racingcar.view;

import java.util.Map;

public class OutputView {
    public void currentLocation(Map<String,Integer> car){
        for (String key : car.keySet()){
            int locationNumber = car.get(key);
            System.out.print(key+" : ");
            printLocation(locationNumber);
        }
    }
    private void printLocation(int locationNumber){
        for (int i=0; i<locationNumber; i++){
            System.out.print("-");
        }
    }
}

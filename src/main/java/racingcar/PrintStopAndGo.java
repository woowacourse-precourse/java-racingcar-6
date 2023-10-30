package racingcar;

import java.util.List;

public class PrintStopAndGo {

    void printStopAndGo(List<String> racingCar, List<Integer> score){
        String hyphen = "-";

        for(int i=0;i<racingCar.size();i++){
            System.out.println(racingCar.get(i)+": "+hyphen.repeat(score.get(i)));
        }
    }
}

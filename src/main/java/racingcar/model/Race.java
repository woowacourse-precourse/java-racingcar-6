package racingcar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Race {
    private List<Integer> carScoreList;

    public void racingCar(int count, List<String> carNameList) {
        carScoreList = new ArrayList<>(
                Collections.nCopies(carNameList.size(),0)
        );

        for (int i = 0; i < count; i++) {
            Forward forward = new Forward();
            carScoreList = forward.moveForward(carScoreList);
            print(carNameList);
        }
    }

    private void print(List<String> carNameList){
        for (int i=0;i<carNameList.size();i++){
            System.out.println(carNameList.get(i) + " : " + "-".repeat(carScoreList.get(i)));
        }
        System.out.println();
    }

}

package racingcar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Race {
    private List<String> carNameList;
    private List<Integer> carScoreList;

    public void racingCar(int count, List<String> carNameArr) {
        carNameList = carNameArr;
        carScoreList = new ArrayList<>(
                Collections.nCopies(carNameList.size(),0)
        );

        for (int i = 0; i < count; i++) {
            Forward forward = new Forward();
            carScoreList = forward.moveForward(carScoreList);
            print();
        }
        findingWinner();
    }

    private void print(){
        for (int i=0;i<carNameList.size();i++){
            System.out.println(carNameList.get(i) + " : " + "-".repeat(carScoreList.get(i)));
        }
        System.out.println();
    }

    private void findingWinner(){
        int max = Collections.max(carScoreList);

        List<String> winner = new ArrayList<>();
        for(int i=0;i<carScoreList.size();i++){
            if(carScoreList.get(i) == max){
                winner.add(carNameList.get(i));
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winner));
    }

}

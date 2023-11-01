package racingcar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Race {

    public List<String> racingCar(int count, List<String> carNameList) {
        List<Integer> carScoreList = new ArrayList<>(
                Collections.nCopies(carNameList.size(), 0)
        );

        for (int i = 0; i < count; i++) {
            Forward forward = new Forward();
            carScoreList = forward.moveForward(carScoreList);
            print(carNameList, carScoreList);
        }
        return findingWinner(carNameList, carScoreList);
    }

    private void print(List<String> carNameList, List<Integer> carScoreList) {
        for (int i = 0; i < carNameList.size(); i++) {
            System.out.println(carNameList.get(i) + " : " + "-".repeat(carScoreList.get(i)));
        }
        System.out.println();
    }

    public List<String> findingWinner(List<String> carNameList, List<Integer> carScoreList) {
        int max = Collections.max(carScoreList);

        List<String> winner = new ArrayList<>();
        for (int i = 0; i < carScoreList.size(); i++) {
            if (carScoreList.get(i) == max) {
                winner.add(carNameList.get(i));
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winner));

        return winner;
    }

}

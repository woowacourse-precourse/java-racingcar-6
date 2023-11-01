package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;



public class EvaluateSystem {
    public int racingCondition() {
        return Randoms.pickNumberInRange(0,9);

    }
    public void winnerDisplay(ArrayList<Integer> finalList, String[] names) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < finalList.size(); i++) {
            System.out.print(names[finalList.get(i)]);
            if (finalList.size() != 1) {
                System.out.print(",");
            }
        }
    }
    public void winnerSearch(ArrayList<ArrayList<Integer>> winnerList, String[] names) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < winnerList.size(); i++) {
            int tempCountValue = 0;
            tempCountValue += winnerCount(winnerList.get(i));
            tempList.add(tempCountValue);
        }
        winnerDisplay(winnerSort(tempList), names);


    }
    public int winnerCount(ArrayList<Integer> tempoList) {
        int nameCount = 0;
        for (int i = 0; i < tempoList.size(); i++) {
            if (tempoList.get(i).equals(1)) {
                nameCount++;
            }
        }
        return nameCount;
    }
    public ArrayList<Integer> winnerSort(ArrayList<Integer> winnerList) {
        ArrayList<Integer> finalList = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>(winnerList);
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int i = 0; i < winnerList.size(); i++) {
            if (sortedList.get(0).equals(winnerList.get(i))) {
                finalList.add(i);
            }
        }
        return finalList;
    }




}

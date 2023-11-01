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
            System.out.print(names[i]);
            if (finalList.size() != 1) {
                System.out.print(",");
            }
        }
    }
    public void winnerSearch(ArrayList<ArrayList<String>> winnerList, String[] names) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int tempCountValue = 0;
        for (int i = 0; i < winnerList.size(); i++) {
            tempCountValue += winnerCount(winnerList.get(i));
            tempList.add(tempCountValue);
        }
        winnerDisplay(winnerSort(tempList), names);


    }
    public int winnerCount(ArrayList<String> tempoList) {
        int nameCount = 0;
        for (int i = 0; i < tempoList.size(); i++) {
            if (tempoList.get(i).equals("=")) {
                nameCount++;
            }
        }
        return nameCount;
    }
    public ArrayList<Integer> winnerSort(ArrayList<Integer> nameList) {
        int nameCount = 0;
        ArrayList<Integer> sortedList;
        ArrayList<Integer> finalList = new ArrayList<>();
        sortedList = nameList;
        Collections.sort(sortedList, Collections.reverseOrder());
        for (int i = 0; i < nameList.size(); i++) {
            if (sortedList.get(0).equals(nameList.get(i)) ) {
                finalList.add(i);
            } else {

            }
        }
        return finalList;
    }




}

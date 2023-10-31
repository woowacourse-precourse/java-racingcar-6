package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class EvaluateSystem {
    public ArrayList<Integer> racingCondition(int inputCount) {
        ArrayList<Integer> racingInProcess = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            racingInProcess.add(Randoms.pickNumberInRange(0,9));
        }
        return racingInProcess;
    }
    public static void winnerDisplay(ArrayList<ArrayList<Integer>> RecordList, String[] name) {
        int sum = 0;
        int max = 0;
        int winnerIndex = 0;
        for (int j = 0; j < RecordList.size(); j++) {
                sum += winnerListCount(RecordList.get(j));

            if (max < sum) {
                max = sum;
                winnerIndex++;
            }
            System.out.println("");
        }
    }
    public static int winnerListCount(ArrayList<Integer> record) {
        int temp = 0;
        for (int i = 0; i < record.size(); i++) {
            temp += record.get(i);
        }
        return temp;
    }
}

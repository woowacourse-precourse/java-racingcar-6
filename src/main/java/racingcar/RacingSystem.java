package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingSystem {
    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
    public static int sequence(int inputCount, int carAmount) {
        EvaluateSystem raceResult = new EvaluateSystem();
        for (int i = 0; i < carAmount; i++) {
            carRecordSheet.add(EvaluateSystem.racingCondition(inputCount));
        }
        for (int j = 0; j < carRecordSheet.size(); j++) {
            for (int k = 0; k < carRecordSheet.get(j).size(); k++) {
                System.out.println("car number " + j + ": " + carRecordSheet.get(j).get(k));
            }
        }
        return 0;
    }
    public void display() {

    }
    public void nameInput() {

    }
    public void moveInput() {

    }

}

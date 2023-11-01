package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.Arrays;

public class RacingSystem {
//    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
    public void nameInput() {
        System.out.printf("자동차 이름은 쉼표(,)를 기준으로 구분하여 작성 부탁 드리며, 이름은 5자 이하로 작성 요망 : ");
        String carNameInput = Console.readLine();
        String[] nameList = carNameInput.split(",");
        ErrorCheckingSystem errorCheck = new ErrorCheckingSystem();
        errorCheck.errorSystem(nameList);
        int inputCount = errorCheck.numberCheck(moveInput());
        sequenceSystem(inputCount, nameList);
    }
    public String moveInput() {
        System.out.printf("몇 번의 이동을 하게 만들 건가요?: ");
        String carNameInput = Console.readLine();
        return carNameInput;
    }
    public int sequenceSystem(int count, String[] carList) {
        int tempCount = 0;
        int raceStep = 0;
        ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
        EvaluateSystem raceCount = new EvaluateSystem();

        while (tempCount < count) {
            addRecord(carRecordSheet, tempCount);
            addRecord(carRecordSheet, raceStep, raceStep, raceCount.racingCondition());
            raceStep++;
            tempCount += 0;
            displaySystem(carRecordSheet, carList);

        }


        return 0;
    }
    public void addRecord(ArrayList<ArrayList<Integer>> recordSheet, int inputCount) {
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(inputCount);
        recordSheet.add(tempList);

    }
    public void addRecord(ArrayList<ArrayList<Integer>> recordSheet, int inputCount, int raceNum, ArrayList<Integer> raceValue) {
        recordSheet.get(inputCount).add(raceValue.get(raceNum));
    }

    public int sequence(String[] carList, int inputCount) {
        EvaluateSystem raceResult = new EvaluateSystem();
        ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();

        for (int i = 0; i < carList.length; i++) {
            carRecordSheet.add(raceResult.racingCondition());
        }

        return 0;
    }
    public static void displaySystem(ArrayList<ArrayList<Integer>> RecordSheet, String[] carName) {
        ArrayList<ArrayList<Integer>> recordWinner = new ArrayList<>();

        for (int j = 0; j < RecordSheet.size(); j++) {
            System.out.printf(carName[j] + "'s car : ");
            for (int k = 0; k < RecordSheet.get(j).size(); k++) {
                displayCheck(RecordSheet.get(j).get(k));
            }

            System.out.println("");
        }
//        EvaluateSystem.winnerDisplay(recordWinner, carName);
    }
    public static void displayCheck(int insertedValue) {
        if (insertedValue >= 4) {
            System.out.printf("=");
        } else {
        }
    }


}

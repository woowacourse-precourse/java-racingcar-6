package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RacingSystem {
//    public static ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();
    EvaluateSystem raceCount = new EvaluateSystem();
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
        ArrayList<ArrayList<Integer>> carRecordSheet = new ArrayList<>();//this is for actual race record
        ArrayList<ArrayList<String>> winnerCheckList = new ArrayList<>();//this is for chcking winner
        addRecord(winnerCheckList, carList);// bring name list to arraylist
        makeRecord(carRecordSheet,carList.length);//declaring column by name
        while (tempCount < count) {
            addRecord(carRecordSheet, carList.length);//recording race
            //raceStep++;
            displaySystem(winnerCheckList, carRecordSheet, carList);
            raceCount.winnerSearch(winnerCheckList, carList);
        }
        return 0;
    }
    public void makeRecord(ArrayList<ArrayList<Integer>> raceSheet, int nameGroupSize) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nameGroupSize; i++) {
            tempList.add(i);
        }
        raceSheet.add(tempList);
    }

    public void addRecord(ArrayList<ArrayList<Integer>> raceSheet, int carListSize) {
        for (int i = 0; i < carListSize; i++) {
            raceSheet.get(i).add(raceCount.racingCondition());
        }
    }
    public void addRecord(ArrayList<ArrayList<String>> resultSheet, String[]ownerList) {
        ArrayList<String> tempName = new ArrayList<>(Arrays.asList(ownerList));
        resultSheet.add(tempName);
    }
    public static void displaySystem(ArrayList<ArrayList<String>> resultRecord, ArrayList<ArrayList<Integer>> RecordSheet, String[] carName) {
        for (int j = 0; j < RecordSheet.size(); j++) {
            System.out.printf(carName[j] + "'s car : ");
            for (int k = 0; k < RecordSheet.get(j).size(); k++) {
                displayCheck(j, RecordSheet.get(j).get(k), resultRecord);
            }

            System.out.println("");
        }
//        EvaluateSystem.winnerDisplay(recordWinner, carName);
    }
    public static void displayCheck(int insertedRow, int insertedValue, ArrayList<ArrayList<String>> resultList) {
        if (insertedValue >= 4) {
            System.out.printf("=");
            resultList.get(insertedRow).add("=");//add "=" into winnerchecklist;
        } else {
            resultList.get(insertedRow).add(" ");
        }
    }


}

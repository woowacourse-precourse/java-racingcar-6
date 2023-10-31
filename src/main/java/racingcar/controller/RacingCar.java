package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.Logics;
import racingcar.model.Errors;
import racingcar.model.DataObj;
import racingcar.controller.*;

import javax.xml.crypto.Data;


public class RacingCar {
    public static void playing () {
        String[] splitNames = inputNames();
        int progressNum = inputNumber();

        Output.printResultMsg();
        DataObj[] Datas = initDataObj(splitNames.length, splitNames);

        printSteps(splitNames, Datas, progressNum);
        printResult(Datas);
    }

    public static String[] inputNames () {
        String names = Input.printNameToBeInput();
        Errors.nameInputThrowError(names);
        return Logics.splitNames(names);
    }

    public static int inputNumber () {
        String inputNumber = Input.printNumToBeInput();
        Errors.numberInputThrowError(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    public static DataObj[] initDataObj (int length, String[] splitNames) {
        DataObj[] Datas = new DataObj[length];
        for(int i = 0; i < Datas.length; i++) {
            Datas[i] = new DataObj();
            Datas[i].setName(splitNames[i]);
        }
        return Datas;
    }

    public static void printSteps (String[] splitNames, DataObj[] datas, int progressNum) {
        for(int i = 0; i < progressNum; i++) {
            for(int j = 0; j < splitNames.length; j++) {
                datas[j].setProgress(Logics.forwardOrNot());
                Output.printProgressing(datas[j].getName(), datas[j].getProgress());
            }
            System.out.println();
        }
    }

    public static void printResult (DataObj[] datas) {
        Output.printWinner(Logics.winners(datas));
    }
}

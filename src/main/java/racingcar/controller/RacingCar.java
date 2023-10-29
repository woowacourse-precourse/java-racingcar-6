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
        DataObj[] Datas = initDataObj(splitNames.length);

        printSteps(splitNames, Datas, progressNum);
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

    public static DataObj[] initDataObj (int length) {
        DataObj[] Datas = new DataObj[length];
        for(int i = 0; i < Datas.length; i++) {
            Datas[i] = new DataObj();
        }
        return Datas;
    }

    public static void printSteps (String[] splitNames, DataObj[] Datas, int progressNum) {
        for(int i = 0; i < progressNum; i++) {
            for(int j = 0; j < splitNames.length; j++) {
                Datas[j].setData(splitNames[j], Logics.forwardOrNot());
                Output.printProgressing(Datas[j].getName(), Datas[j].getProgress());
            }
            System.out.println();
        }
        Output.printWinner(Logics.winners(Datas));
    }
}

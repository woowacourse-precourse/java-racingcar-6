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
        String inputNames = Input.printNameToBeInput();
        Errors.nameInputThrowError(inputNames);
        String[] splitNames = Logics.splitNames(inputNames);

        String inputNumber = Input.printNumToBeInput();
        Errors.numberInputThrowError(inputNumber);
        int progressNum = Integer.parseInt(inputNumber);

        Output.printResultMsg();
        DataObj[] Datas = new DataObj[splitNames.length];
        for (int j = 0; j < splitNames.length; j++) {
            Datas[j] = new DataObj();
        }
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

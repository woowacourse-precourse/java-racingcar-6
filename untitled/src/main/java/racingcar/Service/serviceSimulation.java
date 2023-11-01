package racingcar.Service;
import racingcar.view.*;
import racingcar.controller.*;

import java.util.ArrayList;

public class serviceSimulation  {
    public void run(){
        viewInputCar inputCar = new viewInputCar();
        String[] carNameArray = inputCar.viewInputCar();

        viewInputNumber inputNumber = new viewInputNumber();
        int movementTimeInt = inputNumber.viewInputNumber();

        viewOutputMessage outputMessage = new viewOutputMessage();
        outputMessage.viewOutputMessage();

        controllerMakeStr MakeStr = new controllerMakeStr();
        String[] simulationStringArray = MakeStr.controllerMakeStr(carNameArray);

        controllerSimulation simulation = new controllerSimulation();
        for (int time=0; time<movementTimeInt;time++) {
            simulationStringArray = simulation.controllerSimulation(simulationStringArray);

            for (int i = 0; i < carNameArray.length; i++) {
                System.out.println(simulationStringArray[i]);
            }
            System.out.println();
        }
        controllerWhoWin whoWin = new controllerWhoWin();
        ArrayList<String> winCarArrayList = whoWin.controllerWhoWin(simulationStringArray, carNameArray);

        viewOutputSuccess outputSuccess = new viewOutputSuccess();
        outputSuccess.viewOutputSuccess(winCarArrayList);

    }
}

package racingcar.controller;

public class controllerMakeStr {

    public String[] controllerMakeStr(String[] carName){
        String[] simulationStringArray = new String[carName.length];
        for (int i = 0; i<carName.length;i++){
            simulationStringArray[i] = carName[i] + " : ";
        }

        return simulationStringArray;
    }
}

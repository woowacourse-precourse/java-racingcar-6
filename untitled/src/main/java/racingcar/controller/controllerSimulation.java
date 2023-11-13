package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
public class controllerSimulation {
    public String[] controllerSimulation(String[] simulationStr){

        for (int i=0; i<simulationStr.length;i++){
            int randomNum = Randoms.pickNumberInRange(0,9);
            if(randomNum >= 4){
                simulationStr[i] += "-";
            }
        }
        return simulationStr;
    }
}

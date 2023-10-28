package racingcar;

import java.util.HashMap;

public class RacingGame {
    public void start(){
        Output.tellStartAndGetName();
        String [] carName = Input.getCarName();
        Output.tellGroupName(carName);
        HashMap groupCarName = new HashMap();
        for(String name : carName){
            groupCarName.put(name,"");
        }

        int currentRoundNum=0;
        int gameRoundNum = Input.getGameRoundNum();

        while(gameRoundNum!=currentRoundNum){
            checkStopAndGo(groupCarName,carName);
            Output.tellCurrent(groupCarName,carName);
            currentRoundNum+=1;
        }

        }

        void checkStopAndGo(HashMap name,String[] groupName){
        for(String carName : groupName)
            name.put(carName,name.get(carName)+"-");
        }

    }




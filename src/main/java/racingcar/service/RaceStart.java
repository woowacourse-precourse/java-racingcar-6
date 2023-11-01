package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Game;
import racingcar.view.SystemOutMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceStart {
    Game game = new Game();
    RaceLog raceLog = new RaceLog();

    public RaceStart(){}




    // createRandomNumbers
    public HashMap createRandomNumbers(ArrayList<String> carNameList){
        HashMap<String, Integer> carsPickNumbers = new HashMap<>();
        for(int i=0;i<carNameList.size();i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            carsPickNumbers.put(carNameList.get(i),randomNumber);
        }
        return carsPickNumbers;
    }
    // updateRaceLog
    public void updateRaceLog(ArrayList<String> carNameList, HashMap<String,Integer> tryOne, HashMap<String,String> carLogs, int raceCount){
        for(int i = 0; i < tryOne.size(); i++) {
            String eachCarName = carNameList.get(i);
            if (raceLog.isCarAdvance(tryOne.get(eachCarName))) {
                raceLog.addEachCarsRaceLog(i, carLogs,carNameList);
            }
        }
        if(raceCount == 1){
            game.setRaceResult(carLogs);
        }
    }

    public void showRaceLog(ArrayList<String> carNameList, HashMap raceLog){
        SystemOutMessage.RaceMessage();
        for(int i=0;i<carNameList.size();i++){
            System.out.println(carNameList.get(i)+" : "+raceLog.get(carNameList.get(i)));
        }
    }
}

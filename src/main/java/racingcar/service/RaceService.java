package racingcar.service;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.SystemOutMessage;
import racingcar.view.UserInputMessage;

public class RaceService {
    Cars cars = new Cars();
    Game game = new Game();

    // [readyRace]--------------------------------
    public void ParticipateRace(){
        UserInputMessage.askParticipants();
        String InputCars = Console.readLine();
        splitCarNames(InputCars);

    }
    //기능1-(1) 자동차 이름 쉼표로 분리하기
    public void splitCarNames(String InputCars) throws IllegalArgumentException{
        String[] splitCarNames = InputCars.split(",");

        if(!isLimitFiveChar(splitCarNames)){
            throw new IllegalArgumentException();
        }

        ArrayList<String> saveCarNames = new ArrayList<String>();
        for(int i=0;i<splitCarNames.length;i++){
            saveCarNames.add(splitCarNames[i]);
        }
        cars.setCarNames(saveCarNames);
    }
    //기능1-예외: 자동차 이름이 5자가 넘어갈 때
    public boolean isLimitFiveChar(String[] CarNames)throws IllegalArgumentException {
        for(int i=0;i<CarNames.length;i++) {
            if (CarNames[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    //기능1-(2). 실행횟수 입력받기
    public void askTryCount() throws IllegalArgumentException{
        UserInputMessage.askExecuteNumber();
        String inputCount = Console.readLine();

        if(isInt(inputCount)){
            cars.setRaceCount(Integer.parseInt(inputCount));
        }else if(!isInt(inputCount)){
            throw new IllegalArgumentException();
        }
    }

    public boolean isInt(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // [startRace]--------------------------------
    public void raceStart(){
        int raceCount = cars.getRaceCount();
        ArrayList carNameList = cars.getCarNames();
        HashMap raceLog = createEmptyRaceLog(carNameList);

        while(raceCount > 0){
            HashMap<String,Integer> tryOne = rollRandomNumbers(carNameList);
            updateRaceLog(carNameList, tryOne, raceLog, raceCount);
            showRaceLog(carNameList,raceLog);
            raceCount -= 1;
        }
    }

    public HashMap createEmptyRaceLog(ArrayList<String> carNameList) {
        HashMap<String,String> raceLog = new HashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            raceLog.put(carNameList.get(i),"");
        }
        return raceLog;
    }

    public HashMap rollRandomNumbers(ArrayList<String> carNameList){
        HashMap<String, Integer> carsPickNumbers = new HashMap<>();
        for(int i=0;i<carNameList.size();i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            carsPickNumbers.put(carNameList.get(i),randomNumber);
        }
        return carsPickNumbers;
    }


    public void updateRaceLog(ArrayList<String > carNameList,HashMap<String,Integer> tryOne, HashMap raceLog, int raceCount){
        for(int i=0;i<tryOne.size();i++) {
            String eachCarName = carNameList.get(i);
            if (isCarAdvance(tryOne.get(eachCarName))) {
                addEachRaceLog(i, raceLog,carNameList);
            }
        }
        if(raceCount == 1){
            game.setRaceResult(raceLog);
        }
    }

    public boolean isCarAdvance(int randomNumber){
        if(randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void addEachRaceLog(int i, HashMap<String, String> raceLog,ArrayList<String> carNameList){
        String eachLog = raceLog.get(carNameList.get(i));
        raceLog.replace(carNameList.get(i),eachLog + "-");
    }

    public void showRaceLog(ArrayList<String> carNameList, HashMap raceLog){
        SystemOutMessage.RaceMessage();
        for(int i=0;i<carNameList.size();i++){
            System.out.println(carNameList.get(i)+" : "+raceLog.get(carNameList.get(i)));
        }
    }
    // [prizeWinner] ----------------------------------------------
    public void showWinner(){
        SystemOutMessage.RaceResultMessage();
        ArrayList<String> winnerNames = calculateWinner();

        String winnersJoin = String.join(", ", winnerNames);
        System.out.println(winnersJoin);
    }

    public ArrayList<String> calculateWinner(){
        HashMap<String, String> finalResult = game.getRaceResult();
        ArrayList<String> carNames = cars.getCarNames();

        HashMap<String,Integer> pathLength = calculatePathLength(finalResult,carNames);
        ArrayList<String> winnerNames = new ArrayList<>();
        int maxLength = Collections.max(calculatePathLength(finalResult,carNames).values());

        for(int i = 0;i < pathLength.size();i++){
            if(pathLength.get(carNames.get(i)) == maxLength){
                winnerNames.add(carNames.get(i));
            }
        }
        return winnerNames;
    }

    public HashMap<String,Integer> calculatePathLength(HashMap<String, String> finalResult,ArrayList<String> carNames){
        HashMap<String, Integer> winnersPath = new HashMap<>();

        for(int i = 0; i < finalResult.size(); i++){
            String eachCarName = carNames.get(i);
            winnersPath.put(eachCarName,finalResult.get(eachCarName).length());
        }
        return winnersPath;
    }


}



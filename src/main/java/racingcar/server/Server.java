package racingcar.server;

import racingcar.racer.Racer;
import racingcar.utils.Printer;
import racingcar.utils.Util;
import racingcar.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Racer> racerList;
    private int raceRound;
    public Server(){
        racerList = new ArrayList<>();
    }

    public void confirmRacerList(String racerListString){
        Validator.validateUserInputIsCorrectFormat(racerListString);
        List<String> racerNameList = Util.parseStringToListSplitComma(racerListString);
        addRacerToList(racerNameList);
    }
    private void addRacerToList(List<String> racerNameList){
        for ( String racerName : racerNameList){
            racerList.add(new Racer(racerName));
        }
    }
    public void confirmRaceRound(String raceRoundString){
        Validator.validateUserInputIsCorrectRound(raceRoundString);
        int raceRound = Integer.parseInt(raceRoundString);
        this.raceRound = raceRound;
    }
    public void startRace(){
        System.out.println("실행 결과");
        for (int i =0; i<raceRound;i++){
            continueRace();
            Printer.printRaceResultInProgressWithRacerList(racerList);
        }

    }
    private void continueRace(){
        for (Racer racer : racerList){
            racer.runRaceEachStep();
        }
    }
    public void finishRace(){
        List<String> winnerList = aggregateRaceResults();
        Printer.printRaceResultInTotalWithWinnerList(winnerList);
    }
    private List<String> aggregateRaceResults(){
        int maxPos = 0;
        for ( Racer racer : racerList){
            int racerPos = racer.getCurrentPos();
            if ( racerPos>= maxPos){
                maxPos = racerPos;
            }
        }
        List<String> winnerList = new ArrayList<>();
        for ( Racer racer : racerList){
            if ( racer.getCurrentPos() == maxPos){
                winnerList.add(racer.getName());
            }
        }
        return winnerList;
    }
    public List<Racer> getRacerList(){ return racerList; }
    public int getRaceRound() { return raceRound;}

}
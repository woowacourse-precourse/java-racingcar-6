package racingcar.server;

import racingcar.racer.Racer;
import racingcar.utils.Printer;
import racingcar.utils.Util;
import racingcar.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Racer> racerList;
    private Integer racerCount;
    public Server(){
        racerList = new ArrayList<>();
        racerCount = 0;
    }

    public void confirmRacerList(String racerListString){
        Validator.validateUserInputIsCorrectFormat(racerListString);
        List<String> racerNameList = Util.parseStringToListSplitComma(racerListString);
        for ( String racerName : racerNameList){
            racerList.add(new Racer(racerName));
        }
    }
    public void confirmRacerCount(String racerCountString){
        Validator.validateUserInputIsCorrectCount(racerCountString);
        Integer racerCount = Integer.parseInt(racerCountString);
        this.racerCount = racerCount;
    }
    public void startRace(){
        System.out.println("실행 결과");
        for (int i =0; i<racerCount;i++){
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
        Integer maxPos = 0;
        for ( Racer racer : racerList){
            Integer racerPos = racer.getCurrentPos();
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
    public int getRacerCount() { return racerCount;}

}
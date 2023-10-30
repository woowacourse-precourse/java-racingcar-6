package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private List<Racer> racerList;
    private Validator validator;
    private Integer racerCount;
    Server(){
        racerList = new ArrayList<>();
        validator = new Validator();
        racerCount = 0;
    }

    public void confirmRacerList(String racerListString){
        validator.validateUserInputIsCorrectFormat(racerListString);
        List<String> racerNameList = Util.parseStringToListSplitComma(racerListString);
        for ( String racerName : racerNameList){
            racerList.add(new Racer(racerName));
        }
    }
    public void confirmRacerCount(String racerCountString){
        validator.validateUserInputIsCorrectCount(racerCountString);
        Integer racerCount = Integer.parseInt(racerCountString);
        this.racerCount = racerCount;
    }
    public void startRace(){
        for (int i =0; i<racerCount;i++){
            continueRace();
        }
    }
    private void continueRace(){
        for (Racer racer : racerList){
            racer.runRaceEachStep();
        }
    }

    public List<Racer> getRacerList(){ return racerList; }
    public int getRacerCount() { return racerCount;}

}

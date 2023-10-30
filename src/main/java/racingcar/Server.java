package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private List<Racer> racerList ;
    private Validator validator;
    private Integer racerCount;
    Server(){
        racerList = new ArrayList<>();
        validator = new Validator();
        racerCount = 0;
    }

    public void confirmRacerList(String racerListString){
        validator.validateUserInputIsCorrectFormat(racerListString);
        List<String> racerNameList = Arrays.asList(racerListString.split(","));
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

    }

    public List<Racer> getRacerList(){ return racerList; }
    public int getRacerCount() { return racerCount;}

}

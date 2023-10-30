package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private List<Racer> racerList ;
    private Validator validator;
    Server(){
        racerList = new ArrayList<>();
        validator = new Validator();
    }

    public void confirmRacerList(String racerListString){
        validator.validateUserInputIsCorrectFormat(racerListString);
        List<String> racerNameList = Arrays.asList(racerListString.split(","));
        for ( String racerName : racerNameList){
            racerList.add(new Racer(racerName));
        }
    }

    public List<Racer> getRacerList(){ return racerList; }

}

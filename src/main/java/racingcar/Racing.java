package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static final Integer CARFORWARD_NUMBER = 4;
    public List<String> raceSituation = new ArrayList<>();
    public List<Integer> raceRandomNumbers = new ArrayList<>();

    public void createRace(List<String> carNames) {

        for(String carName : carNames){
            raceSituation.add(carName+" : ");
        }
    }

    public void raceRandomNumberList(List<String> carNames){
        for(int i=0; i<carNames.size(); i++) {
            raceRandomNumbers.add(Computer.CreateRandomNumber());
        }
    }

    public void forwardValidation(List<Integer> raceRandomNumbers){
        for(int i=0; i<raceRandomNumbers.size(); i++){
            if(raceRandomNumbers.get(i) >= CARFORWARD_NUMBER){
                String currentString = raceSituation.get(i);
                currentString += "-";
                raceSituation.set(i, currentString);
            }
        }
    }

}

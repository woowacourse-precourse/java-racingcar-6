package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private static final int CARFORWARD_NUMBER = 4;
    public List<String> raceSituation = new ArrayList<>();
    public List<Integer> forwardCountNumbers = new ArrayList<>();
    public List<Integer> maxIndexs = new ArrayList<>();

    public void racing(List<String> carNames){
        List<Integer> randomNumbersList = raceRandomNumberList(carNames);
        forwardValidation(randomNumbersList);
        OutputMessage.racePrint(raceSituation);
    }

    public void createRace(List<String> carNames) {

        for(String carName : carNames){
            raceSituation.add(carName+" : ");
        }
    }

    public void findWinner(){
        forwardCount(raceSituation);
        findMaxIndex(forwardCountNumbers);
    }

    private List<Integer> raceRandomNumberList(List<String> carNames) {
        List<Integer> raceRandomNumbers = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            raceRandomNumbers.add(Computer.CreateRandomNumber());
        }
        return raceRandomNumbers;
    }

    private void forwardValidation(List<Integer> raceRandomNumbers){
        for(int i=0; i<raceRandomNumbers.size(); i++){
            if(raceRandomNumbers.get(i) >= CARFORWARD_NUMBER){
                String currentString = raceSituation.get(i);
                currentString += "-";
                raceSituation.set(i, currentString);
            }
        }
    }

    private void forwardCount(List<String> raceSituation){
        for(String situation : raceSituation){
            String withoutCount = situation.replace("-", "");
            int count = situation.length() - withoutCount.length();
            forwardCountNumbers.add(count);
        }
    }

    private void findMaxIndex(List<Integer> forwardCountNumbers){
        int max = Collections.max(forwardCountNumbers);
        for(int i=0; i<forwardCountNumbers.size(); i++){
            int current = forwardCountNumbers.get(i);

            if(current == max){
                maxIndexs.add(i);
            }
        }
    }
}

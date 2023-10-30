package racingcar;

import java.util.*;

public class RacingResult {

    private final HashMap<String, Integer> racingMap;
    private final List<String> carList;

    RacingResult(HashMap<String, Integer> racingMap, List<String> carList){
        this.racingMap = racingMap;
        this.carList = carList;
    }

    private List<String> setRacingResult(){
        List<String> winnerList = new ArrayList<>();
        int maxNum = racingMap.get(carList.get(0));

        for(Map.Entry<String, Integer> entry : racingMap.entrySet()){
            int entryNum = entry.getValue();

            if(entryNum > maxNum){
                maxNum = entryNum;
                winnerList.clear();
                winnerList.add(entry.getKey());
            }
            else if(entryNum == maxNum) {
                winnerList.add(entry.getKey());
            }
        }
        return winnerList;
    }

    public void printRacingResult(){
        List<String> winnerList = this.setRacingResult();

        System.out.print("최종 우승자 : ");
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winnerList) {
            joiner.add(winner);
        }
        System.out.println(joiner);
    }
}

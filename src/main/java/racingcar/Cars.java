package racingcar;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Cars {
    Map<String,Integer> carMap = new LinkedHashMap<>();
    int moveCount = 0;
    public Map<String,Integer> createCar(String carName){
        String[] carArr = carName.split(",");
        for(String car:carArr){
            this.carMap.put(car,0);
        }
        return carMap;
    }

     public void moveCar(){
         for( String key : carMap.keySet() ){
             int ranNum = Randoms.pickNumberInRange(0,9);
             if(ranNum >= 4){
                 carMap.replace(key,carMap.get(key) + 1 );
             }
         }
     }

     public void moveCarFor(){
         for(int i=0;i < moveCount;i++){
             this.moveCar();
             GameView.gameCurrent((HashMap<String, Integer>) carMap);
         }
     }
     public List<String> referee(){
        int max = Integer.MIN_VALUE;
        List<String> winner = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: carMap.entrySet()){
            int value = entry.getValue();
            if(value > max){
                max = value;
                winner.clear();
                winner.add(entry.getKey());
            } else if(value == max){
                winner.add(entry.getKey());
            }
        }

        return winner;
     }

}

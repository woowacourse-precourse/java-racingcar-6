package racingcar;
import java.util.*;
public class Racing {
    private final Map<Car,List<Integer>> position = new LinkedHashMap<>();

    Map<Car,List<Integer>> getPosition (){
        return position;
    }
    Racing(String[] cars){
        ready(cars);
    }
    void startRacing(int executeTime){
        for (int i = 0; i < executeTime; i++) {
            moveCar();
        }

    }
    List<String> getWinnersNames(Map<Car,List<Integer>> position){
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = calculateMaxPosition();
        position.keySet().forEach(car -> findWinner(car,maxPosition,winnerNames));
        return winnerNames;
    }
    private void ready(String[] cars){

       for(String name: cars){
           position.put(new Car(name), new ArrayList<>());
       }
    }
    private void moveCar(){
        position.forEach((k,v)->v.add(k.moveForward(new Forward().isSuccess())));
    }
    private int calculateMaxPosition(){
        int max=0;
        for(Car car:position.keySet()){
            max= Math.max(max, car.getNowPosition());
        }
        return max;
    }
    private void findWinner(Car car,int maxPosition,List<String> winnerNames){
        if(maxPosition == car.getNowPosition()){
            winnerNames.add(car.getName());
        }
    }
}

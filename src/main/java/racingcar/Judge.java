package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public List<String> findWinner(List<Car> cars){
        Car car = cars.get(0);
        String maxMove = car.getMove();
        List<String> winner = new ArrayList<>();
        winner.add(car.getName());

        for(int i=1;i<cars.size();i++){
            car = cars.get(i);
            String move = car.getMove();
            if(maxMove.length() < move.length()){
                maxMove = move;
                winner.clear();
                winner.add(car.getName());
            }
            else if(maxMove.length() == move.length()){
                winner.add(car.getName());
            }
        }
        return winner;
    }
}

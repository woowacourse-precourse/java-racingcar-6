package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerCheck {
    public void winnerCheck(List<Racingcar> cars){
        int winnerDistance;
        List<String> winnerList = new ArrayList<>();

        winnerDistance = maxDistance(cars);
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getMoveDistance() == winnerDistance){
                winnerList.add(cars.get(i).getName());
            }
        }
        winnerPrint(winnerList);
    }

    private int maxDistance(List<Racingcar> cars){
        int maxDistanceNum = 0;

        for (int i = 0; i < cars.size(); i++){
            if (maxDistanceNum < cars.get(i).getMoveDistance()){
                maxDistanceNum = cars.get(i).getMoveDistance();
            }
        }
        return maxDistanceNum;
    }

    private void winnerPrint(List<String> winnerList){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if (i != winnerList.size() - 1)
                System.out.print(", ");
        }
    }
}

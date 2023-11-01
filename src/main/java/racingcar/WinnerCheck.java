package racingcar;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class WinnerCheck {
    public void winnerCheck(List<Racingcar> cars){
        BigInteger winnerDistance;
        List<String> winnerList = new ArrayList<>();

        winnerDistance = maxDistance(cars);
        for (int i = 0; i < cars.size(); i++){
            if (winnerDistance.compareTo(cars.get(i).getMoveDistance()) == 0){
                winnerList.add(cars.get(i).getName());
            }
        }
        winnerPrint(winnerList);
    }

    private BigInteger maxDistance(List<Racingcar> cars){
        BigInteger maxDistanceNum = BigInteger.ZERO;

        for (int i = 0; i < cars.size(); i++){
            if (maxDistanceNum.compareTo(cars.get(i).getMoveDistance()) < 0){
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

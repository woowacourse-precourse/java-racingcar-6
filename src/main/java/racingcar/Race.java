package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race{
    private final List<Car> cars;
    private final int tryCount;

    public Race(List<Car> cars, int tryCount){
        this.cars=cars;
        this.tryCount=tryCount;
    }

    public void conductRace(){
        for (int i=1;i<tryCount+1;i++){
            for (Car car : cars){
                // 자동차 이동
                int randomNumber= Randoms.pickNumberInRange(0,9);
                if(randomNumber>=4){
                    car.position++;
                }

                View.printCarMove(car.getCarName(), car.getCarPosition());
            }
            System.out.println();
        }
    }

    private int findMaxPosition(){
        int maxPosition=0;
        for (Car car: cars){
            maxPosition=Math.max(maxPosition, car.getCarPosition());
        }

        return maxPosition;
    }

    List<String> getWinners(){
        int maxPosition=findMaxPosition();
        List<String> winners=new ArrayList<>();
        for (Car car: cars){
            if(car.getCarPosition()==maxPosition){
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
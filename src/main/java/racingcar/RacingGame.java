package racingcar;

import java.util.ArrayList;

public class RacingGame {
    ArrayList<Car> userCars;
    int tryCount;
    RacingGame(ArrayList<Car> userCars, int tryCount){
        this.userCars = userCars;
        this.tryCount = tryCount;
    }

    void startRace(){
        for(int i=0;i<this.tryCount;i++){
            for(Car car : this.userCars){
                RandomDice dice = new RandomDice();
                dice.setNum();
                if(dice.getNum()>=4){
                    car.addProgress();
                }
                System.out.println(car.showProgress());
            }
            System.out.println();
        }
    }

    String checkResult(){
        String winner = "";
        int maxCount = 0;
        for(Car car : this.userCars){
            if(car.getCounter()>maxCount){
                winner = car.name;
                maxCount = car.getCounter();
            }else if(car.getCounter()!=0 && car.getCounter()==maxCount){
                winner += ", "+car.name;
            }
        }
        return winner;
    }
}

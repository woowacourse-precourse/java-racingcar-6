package racingcar.domain;

import java.util.List;

public class RacingGame {
    private List<RacingCar> cars;
    private List<RacingCar> winners;
    public static int tryCount;

    public void addRacingCar(List<String> names){
        for(String name : names){
            RacingCar car = new RacingCar(name);
            cars.add(car);
        }
    }

    public int getCarMove(int index){
        return cars
                .get(index)
                .getMove();
    }

    public List<String> getWinnerNames(){
        List<String> winnerNames = null;
        for(RacingCar winner : winners){
            winnerNames.add(winner.getCarName());
        }
        return winnerNames;
    }

    public void setWinners(){
        int max = findMax();
        for (RacingCar car : cars){
            addWinner(max, car);
        }
    }

    public void addWinner(int max, RacingCar car){
        int carMove = car.getMove();
        if (max == carMove){
            winners.add(car);
        }
    }

    public int findMax(){
        int max = 0;
        for(RacingCar car : cars){
            int carMove = car.getMove();
            max = updateMax(max, carMove);
        }
        return max;
    }

    public int updateMax(int max, int value){
        if (max < value){
            max = value;
        }
        return max;
    }
}

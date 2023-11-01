package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public static List<Car> carList = new ArrayList<>();
    private static int maxStat = 0;

    public void updateCarList(List<String> carNameList){
        for (String name : carNameList){
            carList.add(new Car(name));
        }
    }

    private static boolean isMove(){
        return getRandomNumber() >= 4;
    }

    private static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void executingGame(List<Car> carList){
        for(Car car : carList){
            if(isMove()){
                car.updateStat();
            }
        }
    }

    public static void getMaxStatus(){
        for(Car car : carList){
            int carStat = car.getStat().length();
            if(carStat > maxStat){
                maxStat = carStat;
            }
        }
    }

    public static List<String> getWinner(){
        List<String> winnerList = new ArrayList<>();
        getMaxStatus();
        return getWinnerList(winnerList);
    }

    public static List<String> getWinnerList(List<String> winnerList){
        for (Car car : carList) {
            if (car.getStat().length() == maxStat){
                winnerList.add(car.name);
            }
        }

        return winnerList;
    }



}

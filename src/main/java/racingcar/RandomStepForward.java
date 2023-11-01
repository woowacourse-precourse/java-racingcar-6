package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomStepForward {
    public static void playGames(List<Car> carsList){
        for (Car cars : carsList)
            if(isRandomNumberGreater()) cars.addRun();
    }
    public static void printResultOfRound(List<Car> carsList){
        for(Car car : carsList) {
            System.out.println(car.toString());
        }
    }
    public static boolean isRandomNumberGreater(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}

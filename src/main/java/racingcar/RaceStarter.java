package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RaceStarter {
    public static void startRace(List<Car> cars){
        for(Car car: cars){
            race(car);
        }
        System.out.println();
    }
    public static void race(Car car){
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (pickedNumber >= 4){
            car.move();
        }
        movingPrinter(car.getName(), car.getPosition());
    }
    public static void movingPrinter(String carName, int position){
        System.out.println(carName +" : "+ "-".repeat(position) );
    }
}

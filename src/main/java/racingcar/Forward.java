package racingcar;

public class Forward {
    public static void forwardCar(int number, RCar car){
        if (number >= 4) {
            car.updateforwardCount();
        }
        car.forwardResult();
    }
}

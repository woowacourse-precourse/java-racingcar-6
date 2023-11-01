package racingcar;

public class CarRunner {
    private Car car;
    private static final int MIN_VALUE_TO_PROCEED = 4;
    public CarRunner(Car car){
        this.car = car;
    }
    public void run(){
        int num = Computer.getRandInteger();
        if(num>=MIN_VALUE_TO_PROCEED){
            car.proceed();
        }
    }
}

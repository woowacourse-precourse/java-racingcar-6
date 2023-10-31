package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private User user = new User();

    public void init(){
        String[] carNames = user.getCarName();
        for (String name: carNames){
            cars.add(new Car(name));
        }
        start();
    }

    private void start(){
        int tryCount = user.getTryCount();
        for (int i=0; i<tryCount; i++){
            for (Car car: cars){
                car.move();
            }
            printNowResult();
        }
        getWinner();
    }

    private void printNowResult(){
        for (Car car: cars){
            System.out.println(car.getName()+" : " +"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void printResult() {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private void getWinner() {
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        printResult();
    }
}

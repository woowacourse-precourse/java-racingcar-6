package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    int moveCount;
    private List<Car> carList = new ArrayList<>();

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addCarList(String[] s){
        for(String name:s){
            carList.add(new Car(name));
        }
    }
    public void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }

    public void showResult() {
        System.out.println("\n실행결과");
        for(int i=0;i<moveCount;i++) {
            moveCars();
            for (Car car : carList) {
                System.out.println(car.showLocation());
            }
            System.out.println();
        }
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : carList) {
            int loc=car.getLocation();
            if (loc >= max) {
                if (loc > max)
                    winners.clear();
                winners.add(car.getName());
                max=loc;
            }
        }
        return winners;
    }
    public void showWinners(){
        String winners = Arrays.toString(getWinner().toArray()).replace("[", "").replace("]", "");
        System.out.printf("최종 우승자 : %s",winners);
    }
}

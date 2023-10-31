package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Integer> max_idx = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private static RacingGame instance = new RacingGame();
    public static RacingGame getInstance() {
        return instance;
    }
    /**
     * 생성자 및 Car 객체 추가
     */
    private RacingGame() {
    }
    public void AddCar(Car car) {
        cars.add(car);
    }

    /**
     * 경주
     */
    public void play() {
        for(int idx = 0; idx < cars.size(); idx++) {
            Car car = cars.get(idx);
            System.out.print(car.getName() + ": ");
            car.rolling();
            car.forward();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 결과 발표
     */
    public void result() {
        int max = 0;
        for(Car car : cars) {
            if(max < car.getNum()) {
                max = car.getNum();
            }
        }

        for(int i = 0; i < cars.size(); i++) {
            if( max == cars.get(i).getNum()) {
                max_idx.add(i);
            }
        }

        System.out.print("최종 우승자 : ");
        for(int idx = 0; idx < max_idx.size(); idx++) {
            System.out.print(cars.get(max_idx.get(idx)).getName());
            if( idx+1 != max_idx.size()) {
                System.out.print(", ");
            }
        }
    }
}

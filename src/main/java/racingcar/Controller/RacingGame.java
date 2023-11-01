package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.Dice;
import racingcar.View.Print;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private Dice dice;
    private Integer playTime;
    private Print print;

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.dice = new Dice();
        this.playTime = 0;
        this.print = new Print();
    }

    public void input() {
        print.inputCarNames();
        String in = Console.readLine();
        List<String> names = new ArrayList<>();

        for(String name : in.split(",")) {
            // 동일한 이름의 자동차 추가할 시 에러발생
            if(names.contains(name)) throw new IllegalArgumentException("Error: 동일한 이름의 자동차 추가할 시");
            names.add(name);
            // 자동차 추가
            this.cars.add(new Car(name));
        }
    }

    public void run() {
        print.howMuchRepeat();
        try {
            this.playTime = Integer.parseInt(Console.readLine());

            if (playTime < 0) {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Error: playTime에 양수 아닌 값 입력 시");
        }

        print.runningResult();
        // 2. 각 차마다 다른 랜덤값 적용
        for (int i = 0; i < this.playTime; i++){
            for (Car car : cars) {
                dice.rolling();
                // 3. 4이상일 경우 전진
                if (dice.getValue() >= 4) {
                    car.forward();
                }
            }
            // 4. 과정 출력
            print.step(cars);
        }

        // 5. 최종 우승자 출력
        List<Car> winningCars = winningCarsLogic(cars);
        print.winner(winningCars);
    }

    public List<Car> winningCarsLogic(List<Car> cars) {
        List<Car> winningCars = new ArrayList<>();
        int maxFoward = Integer.MIN_VALUE;

        for (Car car : cars)
            if (maxFoward < car.getForwardValue()) maxFoward = car.getForwardValue();

        for (Car car : cars) {
            if (maxFoward == car.getForwardValue())
                winningCars.add(car);
        }
        return winningCars;
    }


    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", playTime=" + playTime +
                '}';
    }
}

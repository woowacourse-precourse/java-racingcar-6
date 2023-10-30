package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class Game {
    private int count;
    private Car[] cars;
    private String winner;

    Game(){}

    public void init(){
        carsNameInput();
        System.out.println("시도할 횟수는 몇회인가요?");
        this.count = Integer.parseInt(Console.readLine());


    }

    public Car[] carsNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] carNames = carName.split(",");

        return generateCars(carNames);
    }

    public Car[] generateCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i], "");
        }
        return cars;
    }
}

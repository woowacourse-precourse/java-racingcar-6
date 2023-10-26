package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        String[] cars = inputCars.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();

        Car[] carList = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carList[i] = new Car(cars[i]);
        }
    }
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}


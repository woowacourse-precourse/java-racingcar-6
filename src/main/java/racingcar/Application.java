package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분): ");
        String inputCars = Console.readLine();
        String[] carNames = inputCars.split(",");
        int numCars = carNames.length;

        System.out.print("시도할 회수를 입력하세요: ");
        String inputTrys = Console.readLine();
        int numTries = Integer.parseInt(inputTrys);

        int randomNumber = Randoms.pickNumberInRange(0, 9);

        Car[] cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            cars[i] = new Car(carNames[i]);
        }

        for (int i = 0; i < numTries; i++) {
            for (Car car : cars) {
                car.move(randomNumber);
            }
        }

        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        StringJoiner winners = new StringJoiner(", ");
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자: " + winners.toString());
    }


}

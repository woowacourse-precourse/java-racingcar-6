package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        int tryCount;
        int maxPosition =0;

        System.out.print("경주할 자동차 이름을 입력하세요 (쉼표(,)로 구분): ");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }

        System.out.print("시도할 횟수를 입력하세요: ");
        tryCount = Integer.valueOf(Console.readLine());
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                car.printPostion();
            }
            System.out.println();
        }


        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    private static List<Car> cars;

    public static void main(String[] args) {
        String carNames = inputCarNames();
        int tryCount = inputTryCount();

        cars = CarUtils.createCars(carNames);
        System.out.println();

        System.out.println("실행 결과");
        for (int i=0;i<tryCount;i++) {
            play();
        }

        System.out.println("최종 우승자 : " + CarUtils.getWinner(cars));
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }

    private static void play() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
            System.out.println(car.getPositionString());
        }
        System.out.println();
    }

}

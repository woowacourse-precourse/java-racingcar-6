package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Car {
    String name;
    int meter;

    // key는 회차, value 이동 거리
    Map<Integer, Integer> movingLog;

    public Car(String name) {
        this.name = name;
        this.meter = 0;
    }

    public void settingLog(int chance) {
        movingLog = new HashMap<>();
        for(int i=1; i<=chance; i++) {
            movingLog.put(i, 0);
        }
    }
}

public class Application {

    public static void main(String[] args) {
        // 이름 입력 문구를 받는다.
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();

        // 횟수 입력 문구를 받는다.
        System.out.println("시도할 회수는 몇회인가요?");
        int chance = Integer.parseInt(Console.readLine());

        ArrayList<Car> cars = new ArrayList<>();
        for(String name : names.split(",")) {
            // 이름 정보를 가진 차를 생성한다.
            Car car = new Car(name);

            // 차의 로그 기록을 세팅한다.
            car.settingLog(chance);

            // ArrayList에 car를 넣어둔다.
            cars.add(car);
        }

        int init = 1;
        while(init <= chance) {
            System.out.println();
            for(Car car : cars) {
                int number = Randoms.pickNumberInRange(0, 9);
                if(number >= 4) {
                    car.meter++;
                }
                car.movingLog.put(init, car.meter);
                System.out.println(car.name + " : " + "-".repeat(car.movingLog.get(init)));
            }
            init++;
        }

        int max = Integer.MIN_VALUE;
        for(Car car : cars) {
            max = Math.max(car.movingLog.get(chance), max);
        }

        System.out.println();
        final int maxNumber = max;
        String result = cars.stream()
            .filter(car -> car.meter == maxNumber)
            .map(car -> car.name)
            .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + result);

    }
}

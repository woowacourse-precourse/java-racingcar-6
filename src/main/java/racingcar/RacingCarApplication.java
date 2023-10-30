package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarApplication {

    public RacingCarApplication() {
    }

    public void run() {

        // 중복 체크, 이름에 공백 체크, 5자 이하 체크, 시작 및 끝이 ,로 끝나면 체크 등
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.stream(inputCarNames.split(",")).toList();

        Cars cars = Cars.of(carNames);


        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            cars.getCars().forEach(car -> {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.goForward();
                }

                System.out.println(car.getStatusMessage());
            });
            System.out.println();
        }

//        cars.getCars().sort(Car::compareTo);
//
//        Car firstPrizeCar = cars.getCars().get(0);
//
//        String result = cars.getCars().stream()
//                .filter(car -> car.equalsPosition(firstPrizeCar))
//                .map(Car::getCarName)
//                .collect(Collectors.joining(", "));
//
//
//        System.out.println("최종 우승자 : " + result);
    }
}

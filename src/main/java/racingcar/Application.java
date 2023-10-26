package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 오프닝 멘트
        OutputView.racingCarOpeningComment();
        // 자동차 이름 입력 받기
        List<Car> cars = InputView.getCarNames();
        for (Car car : cars) {
            System.out.println("car.getName() = " + car.getName());
        }
        // 도전 횟수 멘트
        OutputView.tryCountInputComment();
        // 도전 횟수 입력 받기
        Integer tryCount = InputView.getTryCount();
        System.out.println("tryCount = " + tryCount);

        // 레이싱 게임 결과 멘트
        OutputView.racingCarResultComment();

        // 레이싱 게임 시작
        for (int i = 0; i < tryCount; i++) {
            cars.stream()
                    .forEach(car -> {
                        car.tryAddPosition();
                        car.carPositionPrint();
                    });
            OutputView.println();
        }

        // 레이싱 결과 출력
        // 최대 거리 값 구하기
        int maxPos = cars.stream().mapToInt(car -> car.getDistance()).max().getAsInt();
        String[] resultArr = cars.stream()
                .filter(car -> car.carEqualsMaxDistance(maxPos))
                .map(car -> car.getName())
                .toArray(String[]::new);

        for (String s : resultArr) {
            System.out.println("s = " + s);
        }


    }
}

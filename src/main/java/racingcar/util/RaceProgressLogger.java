package racingcar.util;

import racingcar.domain.car.Car;
import java.util.List;
import java.util.stream.Stream;

/**
 * 레이싱 게임의 중간 상태를 표현하기 위한 Logger util 클래스입니다.
 */

// todo: 주행 상태도 분리하자
public class RaceProgressLogger {
    /**
     * 각 차량의 주행 거리 로그를 콘솔에 출력합니다.
     *
     * @param carList
     */
    public static void printLog(List<Car> carList) {
        Stream<String> stringStream = logIntermediateResult(carList);
        stringStream.forEach(System.out::println);
    }

    /**
     * 주어진 차량들의 주행 거리 로그 리스트를 반환합니다.
     *
     * @param carList 자동차 리스트
     * @return 주행 거리 로그 리스트
     */
    private static Stream<String> logIntermediateResult(List<Car> carList) {
        return carList.stream().map(RaceProgressLogger::formatCarProgress);
    }

    /**
     * 콘솔에 표시할 차량의 주행 정보 문자열을 반환합니다.
     *
     * @param car 자동차
     * @return 주행 거리 로그
     */
    private static String formatCarProgress(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ").append(progressBar(car.getDrivenDistance()));
        return sb.toString();
    }

    /**
     * 주행 정보를 가시적으로 표현하기 위한 상태바 문자열을 반환합니다.
     * `-` 는 1 거리를 의미합니다.
     * ex) ----- : 5 만큼의 거리를 간 것입니다.
     *
     * @param length 주핼 거리
     * @return 주행 거리 상태바
     */
    private static String progressBar(long length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}

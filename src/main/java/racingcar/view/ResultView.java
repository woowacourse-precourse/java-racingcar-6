package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

/**
 * <p>자동차 경주의 결과를 화면에 출력하는 뷰 클래스입니다.</p>
 *
 * <p>이 클래스는 자동차의 현재 위치와 최종 우승자를 출력하는 기능을 제공합니다.</p>
 */
public class ResultView {

    /**
     * <p>자동차의 현재 위치를 화면에 출력합니다.</p>
     *
     * <p>자동차의 이름과 위치에 따라 "-" 문자로 표시합니다. 예를 들어, 자동차의 이름이 "car"이고
     * 위치가 3이라면 "car : ---"와 같이 화면에 출력됩니다.</p>
     *
     * @param car 위치를 출력할 {@link Car} 객체
     */
    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * <p>모든 자동차의 현재 위치를 화면에 출력합니다.</p>
     *
     * <p>각 자동차의 현재 위치는 {@link #printCarPosition(Car)} 메서드를 통해 출력됩니다.</p>
     *
     * @param cars 위치를 출력할 {@link Car} 객체 리스트
     */
    public static void printRaceResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    /**
     * <p>자동차 경주의 최종 우승자를 화면에 출력합니다.</p>
     *
     * <p>우승자의 이름은 {@link CarFactory#toNameString(List)} 메서드를 통해 문자열로 변환됩니다.</p>
     *
     * @param winners 최종 우승자의 {@link Car} 객체 리스트
     */
    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자 : " + CarFactory.toNameString(winners));
    }
}

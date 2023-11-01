package racingcar.game;

/**
 * 시뮬레이션을 담당하는 클래스
 *
 * @author gemstoneyang
 */
public class Simulator {

    /**
     * 시뮬레이션 메소드
     *
     * @param carList 시도할 자동차들
     * @param tryCount 시도 횟수
     */
    public static void simulateSeveralTimes(CarList carList, int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            carList.tryAllCars();
            carList.printCarsStatus();
        }
    }
}

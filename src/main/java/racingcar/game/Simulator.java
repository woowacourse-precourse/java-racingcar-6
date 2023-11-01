package racingcar.game;

import racingcar.view.DataIOHandler;

/**
 * 시뮬레이션을 담당하는 클래스
 *
 * @author gemstoneyang
 */
public class Simulator {
    CarList carList;
    int tryCount;

    /**
     * 사용자의 입력값을 받아 저장
     */
    public void getUserInput() {
        String commaSeparatedNames = DataIOHandler.getNameInput();
        tryCount = DataIOHandler.getTryCountInput();
        carList = new CarList(commaSeparatedNames);
    }

    /**
     * 시뮬레이션 메소드
     */
    public void simulateSeveralTimes() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            carList.tryAllCars();
            carList.printCarsStatus();
        }
    }

    public void printWinners() {
        System.out.println("\n최종 우승자 : " + carList.getLongestDistanceNames());
    }
}

package racingcar.game;

import racingcar.view.UserInputReceiver;

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
        carList = new CarList(UserInputReceiver.getNameInput());
        tryCount = UserInputReceiver.getTryCountInput();
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

    /**
     * 최종 우승자의 이름을 출력
     */
    public void printWinners() {
        System.out.println("\n최종 우승자 : " + carList.getLongestDistanceNames());
    }
}

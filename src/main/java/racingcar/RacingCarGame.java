package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

/**
 * 레이싱 게임 진행에 대한 기능을 담당
 */
public class RacingCarGame {

    /**
     * 게임에 참여하는 자동차
     */
    private Car[] cars;

    /**
     * 게임을 시작하기 위해 필요한 정보를 받고, 저장한다.
     */
    public void ready() {
        String[] names = readUserNames();
        this.cars = createCars(names);
    }

    /**
     * 사용자로부터 참여할 자동차의 이름을 입력받고, 분할한다.
     *
     * @return 사용자로부터 입력받은 자동차의 이름들
     */
    private static String[] readUserNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String read = Console.readLine();
        String[] names = read.split(","); // 받은 이름을 ,로 분할

        return names; // 분할된 자동차 반환
    }

    /**
     * 이름을 적용한 자동차를 생성하고 반환한다.
     *
     * @param names 생성할 자동차의 이름들
     * @return 자동차들
     */
    private static Car[] createCars(String[] names) {
        Car[] cars = new Car[names.length]; // 이름 수 만큼 자동차 배열 생성
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]); // 자동차 배열을 이름만큼 생성
        }

        return cars;
    }
}

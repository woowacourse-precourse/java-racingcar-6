package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import java.util.Set;
import racingcar.car.CarService;
import racingcar.constants.Constants;

public class GameServiceImpl {
    private Map<String, Integer> carList;
    private int tryCount;
    private int max = 0;

    public void playGame() {

        // 자동차 생성
        System.out.println(Constants.CAR_NAME_TEXT);
        CarService carService = new CarService();
        carList = carService.createCar();

        // 시도 횟수 생성
        System.out.println(Constants.TRY_COUNT_TEXT);
        createTryCount();

        // 실행 결과 출력
        System.out.println(Constants.PLAY_RESULT);
        for (int i = 0; i < tryCount; i++) {
            printResultsByDegree();
        }

        // 최종 우승자 출력
        printFinalWinner();
    }

    // 시도 횟수 생성하는 메소드
    private void createTryCount() {
        try {
            String input = Console.readLine();
            this.tryCount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 각 차수별 실행 결과 출력
    private void printResultsByDegree() {
        Set<Map.Entry<String, Integer>> carListSet = carList.entrySet();
        for (var car : carListSet) {
            String name = car.getKey();
            int forwardNumber = car.getValue();
            if (shouldMoveForward()) {
                forwardNumber++;
                carList.put(name, forwardNumber);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(name + " : ");
            sb.append("-".repeat(forwardNumber));
            System.out.println(sb);

            if (forwardNumber > max) {
                max = forwardNumber;
            }
        }
        System.out.println();
    }

    // 0부터 9까지 숫자 중 무작위 수 하나 생성 후 전진할지 멈출지 판단하는 메소드
    private boolean shouldMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    // 최종 우승자 출력하는 함수
    private void printFinalWinner() {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");

        Set<Map.Entry<String, Integer>> carListSet = carList.entrySet();
        for (var car : carListSet) {
            String name = car.getKey();
            int forwardNumber = car.getValue();
            if (max == forwardNumber) {
                sb.append(name + ", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}

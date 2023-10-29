package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
    private static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRYTIME_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void main(String[] args) {

        UserInput userInput = new UserInput();

        System.out.println(INPUT_CARNAME_MESSAGE);
        List<String> carNames = userInput.getCarNamesInput();

        System.out.println(INPUT_TRYTIME_MESSAGE);
        int tryTime = userInput.getTryTimeInput();

        // 자동차 목록 생성
        Car[] cars = new Car[carNames.size()];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames.get(i));
        }

        // 실행 결과 처리
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        for (int i = 0; i < tryTime; i++) {
            for (Car car : cars) {
                car.forward(setForwardStep());
                car.printForwardState();
            }
            System.out.println();

        }

        // 우승 자동차 판정 처리
        List<String> winners = makeWinnerList(cars);

        // 우승자 출력 처리
        System.out.print(WINNER_MESSAGE);
        printWinner(winners);
    }

    public static int setForwardStep() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            return 1;
        }
        return 0;
    }

    public static int findWinnerForward(Car[] cars) {
        Arrays.sort(cars, Comparator.comparingInt(Car::getForwardCount));

        return cars[cars.length-1].getForwardCount();
    }

    public static List<String> makeWinnerList(Car[] cars) {

        int max = findWinnerForward(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getForwardCount() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void printWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}

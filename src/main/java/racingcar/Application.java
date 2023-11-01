package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    List<String> carList = null;
    List<Integer> carScore = null;

    // 자동차 이름 입력
    public void carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        carList = Arrays.asList(cars.split(","));
        for (String str : carList) {
            if (str.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int times = 0;
        try {
            times = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        // 레이싱게임 메소드 호출
        racingGame(times);
    }

    // 난수 생성 및 게임 진행
    public void randomNum() {
        for (int i = 0; i < carList.size(); i++) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                carScore.set(i, carScore.get(i) + 1);
            }
            // 레이싱 진행상황
            String progress = "";
            for (int j = 0; j < carScore.get(i); j++) {
                progress += "-";
            }
            System.out.println(carList.get(i) + " : " + progress);
        }
    }

    // 레이싱 게임 출력
    public void racingGame(int times) {
        int count = 0;
        carScore = new ArrayList<>(Collections.nCopies(carList.size(), 0));
        while (times > count) {
            randomNum();
            System.out.println();
            count++;
        }
        gameResult();
    }

    // 우승자 출력
    public void gameResult() {
        int max = Collections.max(carScore);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carScore.size(); i++) {
            if (max == carScore.get(i)) {
                winners.add(carList.get(i));
            }
        }
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.carName();
    }
}

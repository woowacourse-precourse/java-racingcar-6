package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Racing {
    List<String> cars = null;
    List<Integer> scores = null;

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        if (cars.contains(" ")) {
            System.out.println("자동차 이름은 공백 없이 입력해주세요.");
            throw new IllegalArgumentException();
        } else if (String.valueOf(cars.charAt(cars.length() - 1)).equals(",")) {
            System.out.println("자동차 이름을 1자 이상 입력해주세요.");
            throw new IllegalArgumentException();
        }
        this.cars = Arrays.asList(cars.split(","));
        for (String str : this.cars) {
            if (str.length() > 5) {
                System.out.println("자동차 이름은 5자 이하로 입력해주세요.");
                throw new IllegalArgumentException();
            } else if (str.length() < 1) {
                System.out.println("자동차 이름을 1자 이상 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int times = 0;
        try {
            times = Integer.parseInt(Console.readLine());
            if (times < 1) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("시도 횟수는 1 이상의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        // 레이싱게임 메소드 호출
        racingGame(times);
    }

    // 난수 생성 및 게임 진행
    public void randomNum() {
        for (int i = 0; i < cars.size(); i++) {
            int num = Randoms.pickNumberInRange(0, 9);
            if (num >= 4) {
                scores.set(i, scores.get(i) + 1);
            }
            // 레이싱 진행상황
            String progress = "";
            for (int j = 0; j < scores.get(i); j++) {
                progress += "-";
            }
            System.out.println(cars.get(i) + " : " + progress);
        }
    }

    // 레이싱 게임 출력
    public void racingGame(int times) {
        int count = 0;
        scores = new ArrayList<>(Collections.nCopies(cars.size(), 0));
        while (times > count) {
            randomNum();
            System.out.println();
            count++;
        }
        gameResult();
    }

    // 우승자 출력
    public void gameResult() {
        int max = Collections.max(scores);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            if (max == scores.get(i)) {
                winners.add(cars.get(i));
            }
        }
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);
    }
}

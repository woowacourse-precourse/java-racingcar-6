package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<String> car;
    static Map<String, Integer> howManyGo;
    static int round;

    static boolean exceptionOccurred;

    public static void main(String[] args) {
        car = new ArrayList<>();
        howManyGo = new HashMap<>();
        round = 0;
        exceptionOccurred = false;

        startGame();

        if(exceptionOccurred) {
            return;
        }

        int cnt = 1;
        while(cnt <= round) {
            racing();
            racingResult();
            System.out.println();
            cnt++;
        }
        whoWin();
    }

    public static void startGame() {
        System.out.println("경주할 자동차 이름을 이름을 입력하세요." +
                "(이름은 쉼표(,) 기준으로 구분)");
        String User = Console.readLine();
        for (String person : User.split(",")) {
            if(person.length() > 5) {
                exceptionOccurred = true;
                throw new IllegalArgumentException();
            }else {
                car.add(person);
                howManyGo.put(person, 0);
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String roundValue = Console.readLine();
        try {
            round = Integer.parseInt(roundValue);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void racing () {
        for (String s : car) {
            int tmp = Randoms.pickNumberInRange(0, 9);
            if (tmp >= 4) {
                howManyGo.put(s, howManyGo.get(s) + 1);
            }
        }
    }

    public static void racingResult() {
        for (String s : car) {
            if(howManyGo.get(s) == null) {
                System.out.println(s + " : ");
            }else {
                System.out.println(s + " : " +
                        repeat(howManyGo.get(s)));
            }
        }
    }

    public static void whoWin() {
        int winValue = Collections.max(howManyGo.values());
        List<String> winner = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : howManyGo.entrySet()) {
            if(entry.getValue() == winValue) {
                winner.add(entry.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    public static String repeat(int num) {
        return "-".repeat(Math.max(0, num));
    }
}


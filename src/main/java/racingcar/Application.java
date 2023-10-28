package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String str = Console.readLine();

        List<String> participant = Arrays.asList(str.split(","));
        List<String> distance = new ArrayList<>();

        for (int i = 0; i < participant.size(); i++) {
            distance.add(i, "");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        int count = Integer.parseInt(Console.readLine());

        System.out.println(participant);

        System.out.println("실행 결과");

        do {

            for (int i = 0; i < participant.size(); i++) {

                int randomNumber = Randoms.pickNumberInRange(0,9);

                if (randomNumber >= 4) {
                    distance.set(i, distance.get(i) + "-");
                }

                System.out.println(participant.get(i) + " : " + distance.get(i));

            }

            System.out.println();

            count--;

        } while (count > 0);

        int max = 0;

        System.out.print("최종 우승자 : ");
        for (String leng : distance) {
            max = Math.max(max, leng.length());
        }

        for (int i = 0; i < participant.size(); i++) {
            if (distance.get(i).length() == max) {
                System.out.println(participant.get(i));
            }
        }

    }
}

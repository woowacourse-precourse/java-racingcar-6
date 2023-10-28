package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.stream(Console.readLine().split(","))
                        .toList();
        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        List<Integer> progress = new ArrayList<>(Collections.nCopies(cars.size(), 0));
        System.out.println(progress);
        for (int i = 0; i < round; i++) {  // 라운드 시작
            for (int j = 0; j < cars.size(); j++) {  // 각 차의 주사위
                int dice = Randoms.pickNumberInRange(0, 9);
                if (dice >= 4) {  // 전진
                    int lastProgress = progress.get(j);
                    progress.set(j, lastProgress + 1);
                }
            }

            for (int j = 0; j < cars.size(); j++) {  // 라운드 결과 출력
                int carAt = progress.get(j);
                System.out.printf("%s : %s\n", cars.get(j), "-".repeat(carAt));
            }
            System.out.println();
        }

        // 우승자 출력
        int maxMove = Collections.max(progress);
        List<String> winner = IntStream.range(0, cars.size())
                .filter(i -> progress.get(i) == maxMove)
                .mapToObj(cars::get)
                .toList();
        System.out.print("최종 우승자 : ");
        if (winner.size() == 1) {
            System.out.println(winner.get(0));
        } else {
            System.out.println(String.join(", ", winner));
        }

        Console.close();
    }
}

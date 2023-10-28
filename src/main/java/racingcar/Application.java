package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Player> players = new ArrayList<>();
        inputNames().forEach(name -> players.add(new Player(name)));

        int num = inputNumber();

        int max = Integer.MIN_VALUE;

        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (Player player : players) {
                player.run();

                if (player.getRunCount() > max) {
                    max = player.getRunCount();
                }

                player.print();
            }
            System.out.println();
        }

        List<Player> winner = new ArrayList<>();
        for (Player player : players) {
            if (player.getRunCount() == max) {
                winner.add(player);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            sb.append(winner.get(i).getName());

            if(i < winner.size() - 1){
                sb.append(", ");
            }
        }

        System.out.println(sb);
    }

    private static int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int num = 0;
        try {
            num = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());

            if(num < 0) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
        }
        return num;
    }

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> names = new ArrayList<>();
        String name;

        StringTokenizer st = new StringTokenizer(camp.nextstep.edu.missionutils.Console.readLine(), ",");
        while (st.hasMoreElements()) {
            name = st.nextToken();

            names.add(name);
        }

        try {
            validateNames(names);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex);
        }

        return names;
    }

    private static void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름을 입력해주세요.");
        }

        names.stream().forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 5글자가 넘습니다.");
            }
        });
    }
}

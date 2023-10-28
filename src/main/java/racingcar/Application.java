package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputNames();

        List<Player> players = Arrays.asList(new Player("honi"), new Player("jun"), new Player("woni"));

        System.out.println("실행 결과");
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.run();
                player.print();
            }
            System.out.println();
        }
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
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        names.stream().forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자가 넘습니다.");
            }
        });
    }
}

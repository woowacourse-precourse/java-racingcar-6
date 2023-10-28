package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Player> players = inputPlayers();

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

            if (i < winner.size() - 1) {
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
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
        }

        if (num <= 0) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
        }

        return num;
    }

    public static List<Player> inputPlayers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Player> players = new ArrayList<>();

        for (String name : camp.nextstep.edu.missionutils.Console.readLine().split(",")) {
            if(validateName(name)){
                players.add(new Player(name));
            }
        }

        return players;
    }

    private static boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름을 입력해주세요.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 5글자가 넘습니다.");
        }

        if(name.contains(" ")){
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름에는 스페이스 바가 들어갈 수 없습니다.");
        }

        return true;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {


    Map<String, String> map = new HashMap<>();
    List<String> winnersList = new ArrayList<>();


    public String[] initPlayer(String input) {

        return input.split(",");
    }

    public void checkPlayerNameLength(String[] players) {

        for (String player : players) {
            if (player.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void savePlayer(String[] players) {

        for (String player : players) {
            map.put(player, "");
        }
    }

    public Integer checkRoundsInput(String input) {


        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void playRound() {

        for (String player : map.keySet()) {
            int input = Randoms.pickNumberInRange(0, 9);
            if (input >= 4) {
                StringBuilder sb = new StringBuilder(map.get(player));
                sb.append("-");
                map.put(player, sb.toString());
            }
        }
    }

    public void printRoundResult() {

        StringBuilder sb = new StringBuilder();

        for (String player : map.keySet()) {
            sb.append(player).append(" : ").append(map.get(player)).append("\n");
        }

        System.out.println(sb);
    }

    public Integer getMaxValue() {

        int max = 0;

        for (String player : map.values()) {
            int result = player.length();
            if (max < result) {
                max = result;
            }
        }

        return max;
    }

    public void getWinner(int max) {

        for (String player : map.keySet()) {
            int tmp = map.get(player).length();

            if (tmp == max) {
                winnersList.add(player);
            }
        }
    }

    public void printWinner() {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        int i;
        for (i = 0; i < winnersList.size() - 1; i++) {
            sb.append(winnersList.get(i)).append(", ");
        }

        sb.append(winnersList.get(i));

        System.out.println(sb);
    }

    public void run() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] tmpPlayer = initPlayer(Console.readLine());
        checkPlayerNameLength(tmpPlayer);
        savePlayer(tmpPlayer);

        System.out.println("시도할 회수는 몇회인가요?");
        String tmpRounds = Console.readLine();
        int numOfRounds = checkRoundsInput(tmpRounds);
        System.out.println("실행 결과");
        for (int i = 0; i < numOfRounds; i++) {
            playRound();
            printRoundResult();
        }

        int max = getMaxValue();
        getWinner(max);
        printWinner();


    }
}

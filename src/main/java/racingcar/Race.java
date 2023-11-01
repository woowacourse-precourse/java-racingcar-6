package racingcar;

import static racingcar.io.ErrorHandler.checkLength;
import static racingcar.io.ErrorHandler.checkRound;
import static racingcar.io.ErrorHandler.checkUnique;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {
    private String userInput;
    public static List<String> players;
    private HashMap<String, Integer> playingStatus = new HashMap<>();
    private Integer roundInt;
    public static List<String> winners = new ArrayList<>();


    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Console.readLine();
        separatePlayers(userInput);
        initHashmap();
        printPlayers();
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();
        checkRound(round);

        System.out.println("실행 결과");
        roundInt = Integer.parseInt(round);
        for (int i = 0; i < roundInt; i++) {
            play();
            printEachRound();
        }
        findWinner();
    }

    public void separatePlayers(String userInput) {
        players = List.of(userInput.replaceAll("\\s+", "").split(","));
        for (String player : players) {
            checkLength(player);
        }
    }

    public void initHashmap() {
        for (String player : players) {
            checkUnique(player, playingStatus);
            playingStatus.put(player, 0);
        }
    }

    public void printPlayers() {
        String print = players.stream().
                map(Object::toString).
                collect(Collectors.joining(",")).toString();
        System.out.println(print);
    }

    public void updateStatus(String player) {
        playingStatus.put(player, playingStatus.get(player) + 1);
    }

    private void move(String player) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            updateStatus(player);
        }
    }

    private void play() {
        for (String player : players) {
            move(player);
        }
    }

    private StringBuilder printDash(StringBuilder stringBuilder, String player) {
        for (int i = 0; i < playingStatus.get(player); i++) {
            stringBuilder.append("-");
        }
        return stringBuilder;
    }

    private void printEachRound() {
        for (String player : players) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(player).append(" : ");
            stringBuilder = printDash(stringBuilder, player);
            System.out.println(stringBuilder);
        }
        System.out.println();
    }


    private void findWinner() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        int maxValue = Collections.max(playingStatus.values());
        for (Map.Entry<String, Integer> set :
                playingStatus.entrySet()) {
            if (maxValue == set.getValue()) {
                winners.add(set.getKey());
            }
        }
        String print = winners.stream().
                map(Object::toString).
                collect(Collectors.joining(", ")).toString();
        stringBuilder.append(print);
        System.out.println(stringBuilder);
    }
}

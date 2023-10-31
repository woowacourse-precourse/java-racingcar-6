package racingcar.domain;

import java.util.*;

public class Leaderboard {

    public Map<String, Integer> board = new LinkedHashMap<String, Integer>();

    public Leaderboard(List<String> names) {
        for (String name : names) {
            board.put(name, 0);
        }
    }

    public void round() {
        for (String name : board.keySet()) {
            int currentPlace = board.get(name);

            if (new Car().engine()) {
                board.put(name, currentPlace + 1);
            }
        }
    }

    public void status() {
        for (String name : board.keySet()) {
            System.out.printf(name + " : ");
            distance(board.get(name));
            System.out.println();
        }
        System.out.println();
    }

    public void distance(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }

    public void winner() {
        List<String> winnerList = new ArrayList<String>();
        int maxDistance = Collections.max(board.values());

        for (String name : board.keySet()) {
            if (maxDistance == board.get(name)) {
                winnerList.add(name);
            }
        }

        System.out.print(winnerFormat(winnerList));
    }

    public String winnerFormat(List<String> winnerList) {
        String format = "";

        for (String name : winnerList) {
            if (format.isEmpty()) {
                format = format + name;
            } else {
                format = format + (", " + name);
            }
        }

        return "최종 우승자 : " + format;
    }

}
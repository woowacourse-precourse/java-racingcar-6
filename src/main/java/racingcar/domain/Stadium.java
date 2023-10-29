package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 경주를 진행하는 장소
 */
public class Stadium {
    private final int gameCount;
    private final List<User> users;

    public Stadium(int gameCount, List<User> users) {
        this.gameCount = gameCount;
        this.users = users;
    }

    public static Stadium of(int gameCount, List<String> nameList) {
        List<User> users = nameList.stream().map(User::of).toList();
        return new Stadium(gameCount, users);
    }

    public void startRace() {
        IntStream.range(0, gameCount).forEach(i -> {
            playEachStep();
        });
    }

    private void playEachStep() {
        users.forEach(user -> {
            user.decideProceed();
            System.out.println(user.visualizeProgress());
        });
        System.out.println();
    }

    public void confirmWinner() {
        List<User> winner = chooseWinner();
        displayResult(winner);
    }

    public static void displayResult(List<User> winner) {
        List<String> winnerNames = winner.stream().map(user -> " " + user.getName()).toList();
        String resultMessage = String.join(",", winnerNames);
        System.out.println("최종 우승자 :" + resultMessage);
    }

    public List<User> chooseWinner() {
        List<User> winner = new ArrayList<>(List.of(User.of("")));
        users.forEach(user -> {
            if (user.isFasterThen(winner)) {
                winner.clear();
                winner.add(user);
            }
        });
        return winner;
    }
}

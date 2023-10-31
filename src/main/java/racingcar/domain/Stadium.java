package racingcar.domain;

import racingcar.utils.output.RacingOutputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 경주를 진행하는 장소
 */
public class Stadium {
    private final int gameCount;
    private final List<User> users;

    private Stadium(int gameCount, List<User> users) {
        this.gameCount = gameCount;
        this.users = users;
    }

    public static Stadium of(int gameCount, List<String> nameList) {
        List<User> users = nameList.stream().map(User::of).toList();
        return new Stadium(gameCount, users);
    }

    public void startRace() {
        IntStream.range(0, gameCount).forEach(i -> setUsersProceedCount());
    }

    private void setUsersProceedCount() {
        users.forEach(user -> {
            user.decideProceed();
            RacingOutputManager.of(user).output();
        });
        System.out.println();
    }

    public void concludeResult() {
        List<User> winner = getWinner();
        displayResult(winner);
    }

    public static void displayResult(List<User> winner) {
        List<String> winnerNames = winner.stream().map(user -> " " + user.getName()).toList();
        String resultMessage = "최종 우승자 :" + String.join(",", winnerNames);
        System.out.println(resultMessage);
    }

    public List<User> getWinner() {
        List<User> winner = new ArrayList<>();
        users.stream().filter(user -> user.isFasterThen(winner)).forEach(user -> {
            winner.clear();
            winner.add(user);
        });
        return winner;
    }

    public List<User> getUsers() {
        return users;
    }
}

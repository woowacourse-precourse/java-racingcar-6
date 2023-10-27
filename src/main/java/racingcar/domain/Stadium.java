package racingcar.domain;

import java.util.List;

/**
 * 경주를 진행하는 장소
 */
public class Stadium {
    private int gameCount;
    private List<User> users;

    public Stadium(int gameCount, List<User> users) {
        this.gameCount = gameCount;
        this.users = users;
    }
    public static Stadium of(int gameCount, List<String> nameList) {
        List<User> users= nameList.stream()
                .map(name -> User.of(name, new RacingCar()))
                .toList();
        return new Stadium(gameCount,users);
    }
}

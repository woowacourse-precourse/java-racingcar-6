package racingcar.PlayGame;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.player.User;

        public class FindWinner {

            public List<String> findWinner(List<User> user) {

                List<String> maxScoreUserNames = user.stream()
                        .collect(Collectors.groupingBy(User::getForwardDistance))
                        .entrySet().stream()
                        .max((entry1, entry2) -> Integer.compare(entry1.getKey(), entry2.getKey()))
                        .map(entry -> entry.getValue())
                        .orElseThrow()
                        .stream()
                        .map(User::getUserName)
                        .collect(Collectors.toList());

                return maxScoreUserNames;
    }

}

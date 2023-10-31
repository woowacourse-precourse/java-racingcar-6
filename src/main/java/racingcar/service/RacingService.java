package racingcar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.RacingPlayer;
import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidNameException;
import racingcar.util.NumberPicker;

public class RacingService {
    public void validateNames(List<String> racerList) {
        Set<String> nameSet = new HashSet<>();

        if (racerList.size() == 1) {
            throw new InvalidNameException("혼자서 게임을 진행할 수 없습니다.");
        }

        for (String name : racerList) {
            if (name.isEmpty() || name.length() > 5) {
                throw new InvalidNameException("이름은 공백일 수 없으며, 5자를 초과할 수 없습니다.");
            }

            if (!nameSet.add(name)) {
                throw new InvalidNameException("중복된 이름이 있습니다: " + name);
            }
        }
    }

    public void validateCount(String count) {
        if (!count.matches("-?\\d+")) {
            throw new InvalidCountException("입력한 값이 정수가 아닙니다.");
        }

        try {
            int parsedCount = countStringToInt(count);
            if (parsedCount <= 0) {
                throw new InvalidCountException("입력한 값이 0 이하입니다. 1 이상의 숫자를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidCountException("입력한 값이 숫자가 아닙니다.");
        }
    }

    public List<RacingPlayer> storeCarNames(List<String> racerList) {
        List<RacingPlayer> players = new ArrayList<>();

        for (String name : racerList) {
            RacingPlayer player = new RacingPlayer(name);
            players.add(player);
        }

        return players;
    }

    public void updateScoreIfNecessary(List<RacingPlayer> players) {
        NumberPicker numberPicker = new NumberPicker();

        for (RacingPlayer player : players) {
            if (numberPicker.pickRandomNumber() > 3) {
                player.setScore();
            }
        }
    }

    public String checkFinalScores(List<RacingPlayer> players) {
        int score = 0;
        StringBuilder winner = new StringBuilder();

        for (RacingPlayer player : players) {
            if (score < player.getScore()) {
                score = player.getScore();
            }
        }

        for (RacingPlayer player : players) {
            if (score == player.getScore() && winner.isEmpty()) {
                winner.append(player.getName());
            } else if (score == player.getScore()) {
                winner.append(", ").append(player.getName());
            }
        }

        return winner.toString();
    }

    public List<String> racerNameStringToList(String racerName) {
        String[] items = racerName.split(",");

        List<String> racerList = new ArrayList<>();

        for (String name : items) {
            racerList.add(name.trim());
        }

        return racerList;
    }

    public int countStringToInt(String count) {

        return Integer.parseInt(count);
    }
}

package racingcar.service;

import racingcar.domain.CarPlayer;
import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidNameException;
import racingcar.util.NumberSelector;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void validateNames(List<String> carList) {
        for (String name : carList) {
            if (name.isEmpty() || name.length() > 5) {
                throw new InvalidNameException("이름은 공백일 수 없으며, 5자를 초과할 수 없습니다.");
            }
        }
    }

    public void validateCount(String count) {
        try {
            Integer.parseInt(count);
            if(Integer.parseInt(count) < 0){
                throw new InvalidCountException("입력한 값이 양수가 아닙니다.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidCountException("입력한 값이 숫자가 아닙니다.");
        }
    }

    public List<CarPlayer> saveCarNames(List<String> carList) {
        List<CarPlayer> players = new ArrayList<>();
        int id = 1;

        for (String name : carList) {
            CarPlayer player = new CarPlayer(id++, name);
            players.add(player);
        }
        return players;
    }

    public void updateCarScore(List<CarPlayer> players) {
        NumberSelector numberSelector = new NumberSelector();

        for (CarPlayer player : players) {
            if (numberSelector.pickRandomNumber() > 3) {
                player.setScore();
            }
        }
    }

    public String checkFinalScores(List<CarPlayer> players) {
        int score = 0;
        StringBuilder winner = new StringBuilder();

        for (CarPlayer player : players) {
            if (score < player.getScore()) {
                score = player.getScore();
            }
        }

        for (CarPlayer player : players) {
            if (score == player.getScore() && winner.isEmpty()) {
                winner.append(player.getName());
            } else if (score == player.getScore()) {
                winner.append(", ").append(player.getName());
            }
        }
        return winner.toString();
    }

    public List<String> carNameStringToList(String carName) {
        String[] items = carName.split(",");

        List<String> carList = new ArrayList<>();

        for (String name : items) {
            carList.add(name.trim());
        }

        return carList;
    }

    public int countStringToInt(String count) {
        return Integer.parseInt(count);
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<String> setThePlayer(String player) {   //플레이어 설정
        List<String> PlayerList = Arrays.stream(player.split(",")).map(String::trim)
                .collect(Collectors.toList());
        nameError(PlayerList); //이름에 대한 예외 처리
        return PlayerList;
    }

    public List<Integer> setScore(List<String> playerList) {
        List<Integer> scoreList = new ArrayList<>();
        for (String playerName : playerList) {
            scoreList.add(0);
        }
        return scoreList;
    }

    private void nameError(List<String> strList) {
        for (String str : strList) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자까지 입력 가능합니다.");
            }
        }
    }
}



package racingcar.service;

import racingcar.domain.Player;
import racingcar.domain.PlayerRepository;

public class RacingGameService {
    private final PlayerRepository playerRepository = new PlayerRepository();
    // 게임 초기화 함수
    public void initGame(String playerInput){
        //parsing
        String[] playerNames = inputParser(playerInput);

        //Player creation and add to repository
        for (String playerName:playerNames) {
            playerRepository.addPlayer(createPlayer(playerName));
        }



    }
    //input에서 사용자 이름 파싱
    private String[] inputParser(String inputString) throws IllegalArgumentException{
        String[] tokens = inputString.split(",");
        for (String token: tokens){
            //TODO: vailidation
        }
        return tokens;
    }
    // Player 생성 메서드
    private Player createPlayer(String playerName){
        return new Player(playerName);
    }

    // 전진 구현

    // 우승자 선출

}

package racingcar.service;

import racingcar.domain.Player;
import racingcar.domain.PlayerRepository;

public class RacingGameService {
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final int MAXNAMELENGTH = 5;
    private final int MINNAMELENGTH = 1;
    private int gameAttempts;
    // 게임 초기화 함수
    public void initGame(String playerInput, String attempts){
        //parsing name
        String[] playerNames = inputParser(playerInput);

        //Player creation and add to repository
        for (String playerName:playerNames) {
            playerRepository.addPlayer(createPlayer(playerName));
        }
        //set attempts
        setGameAttempts(attemptParseToInt(attempts));


    }
    //게임 회수 setter
    public void setGameAttempts(int gameAttempts) {
        this.gameAttempts = gameAttempts;
    }

    // 게임 회수 getter
    public int getGameAttempts() {
        return gameAttempts;
    }

    //input에서 사용자 이름 파싱
    private String[] inputParser(String inputString) throws IllegalArgumentException{
        String[] tokens = inputString.split(",");
        for (String token: tokens){
            //Validation
            if (token.length()<MINNAMELENGTH || token.length()>MAXNAMELENGTH ){
                throw new IllegalArgumentException();
            }
        }
        return tokens;
    }
    // Player 생성 메서드
    private Player createPlayer(String playerName){
        return new Player(playerName);
    }
    // 시도회수 형 변환
    private int attemptParseToInt(String attempts) throws IllegalArgumentException{
        int parsedInt = Integer.parseInt(attempts);
        //입력값이 0보다 작은 경우 예외 처리
        if (parsedInt < 0){
            throw new IllegalArgumentException();
        }
        return parsedInt;

    }



    // 전진 구현

    // 우승자 선출

}

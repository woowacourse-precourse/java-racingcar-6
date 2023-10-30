package racingcar.service;

public class RacingGameService {
    // 게임 초기화 함수
    public void initGame(String playerInput){
        //parsing
        inputParser(playerInput);

        //Player creation



    }

    private void inputParser(String inputString) throws IllegalArgumentException{
        String[] tokens = inputString.split(",");
        for (String token: tokens){
            System.out.println("token = " + token);
            //TODO: vailidation
        }
    }
    // 전진 구현

    // 우승자 선출

}

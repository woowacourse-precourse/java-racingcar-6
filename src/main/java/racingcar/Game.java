package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String SETPLAYERTEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SETCOUNTTEXT = "시도할 회수는 몇회인가요?";
    private static final String SCORETEXT = "실행결과";
    private static final String WINNERTEXT = "최종 우승자 : ";
    GameManager gameManager;
    Game(){
    }

    public void startGame(){
        System.out.println(SETPLAYERTEXT);
        String playerText = Console.readLine();
        System.out.println(SETCOUNTTEXT);
        String countString = Console.readLine();
        gameManager = new GameManager(Integer.parseInt(countString));
        gameManager.setPlayers(playerText);
        System.out.println(SCORETEXT);
        gameManager.play();
        gameManager.findWinner();
        System.out.println(WINNERTEXT);
        gameManager.print();
    }
}

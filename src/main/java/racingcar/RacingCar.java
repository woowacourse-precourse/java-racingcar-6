package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCar {
    public static final String carName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String gameNum = "시도할 회수는 몇회인가요?";

    public Player players;
    public List<String> members;
    public int games;
    public Score scoreBoard;

    public RacingCar(){
        getUser();
        games = getGameNum();
        scoreBoard = new Score(members.size());
        Games();
    }

    public void getUser(){
        players = new Player();

        System.out.println(carName);

        members = players.getMember(Console.readLine());
    }

    public int getGameNum(){
        System.out.println(gameNum);
        String num = Console.readLine();
        return Integer.parseInt(num);
    }

    public void Game(){
        for(int i = 0;i<members.size();i++){
            scoreBoard.countScore(scoreBoard.randNum(), i);
        }
    }

    public void Games(){
        for(int i = 0; i < games;i++){
            Game();
            scoreBoard.printResult();
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCar {
    public static final String carName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String gameNum = "시도할 회수는 몇회인가요?";
    public static final String result = "실행 결과";
    public static final String win = "최종 우승자 : ";

    public Player players;
    public Validation test;
    public int games;
    public Score scoreBoard;

    public List<String> winner;

    public RacingCar(){
        test = new Validation();
        players = new Player();

        getUser();

        test.inputCheck(players);

        games = getGameNum();
        scoreBoard = new Score(players.getSize());

        Games();
        chooseWinner();
        printResult();
    }

    public void getUser(){
        System.out.println(carName);

        players.getMember(Console.readLine());
    }

    public int getGameNum(){
        System.out.println(gameNum);

        String num = Console.readLine();
        test.typeCheck(num);

        return Integer.parseInt(num);
    }

    public void Game(){
        for(int i = 0;i<players.getSize();i++){
            scoreBoard.countScore(scoreBoard.randNum(), i);
        }
    }

    public void Games(){
        System.out.println("\n" + result);
        for(int i = 0; i < games;i++){
            Game();
            printScore();
            if(i!=games-1){
                System.out.println();
            }
        }
    }

    private void printScore(){
        for(int i=0;i<players.getSize();i++){
            System.out.print(players.getName(i) + " : ");
            scoreBoard.printResult(i);
            System.out.println();
        }
    }

    private void chooseWinner(){
        winner = scoreBoard.printWinner(players);
    }

    private void printResult(){
        System.out.println();
        System.out.print(win);
//        for (String player : winner){
//            System.out.print(player);
//        }
        System.out.print(String.join(", ", winner));
    }
}

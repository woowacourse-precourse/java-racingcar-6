package racingcar;

import racingcar.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AskPlayer askPlayer = new AskPlayer();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = askPlayer.askName();
        System.out.println("시도할 회수는 몇회인가요?");
        int playCount = askPlayer.askHowMany();
        Play play = new Play();

        System.out.println("\n실행 결과");
        play.playGame(cars, playCount);

        Referee referee = new Referee();
        List<String> winners = referee.whoIsWinner(cars);
        for (String s:winners){
            System.out.print(s+' ');
        }






    }
}

package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        RacingContest racingContest;
        List<String> winners;
        String result = "죄종 우승자 : ";

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String players = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());
        
        racingContest = new RacingContest(round);
        for(String racingCar :players.split(",")){
            //사용자가 자동차 이름을 입력하지 않았거나 5글자보다 많이 입력한 경우 Exception
            if(racingCar.length()==0||racingCar.length()>5){
                throw new IllegalArgumentException();
            }

            racingContest.insertCar(new RacingCar(racingCar));
        }

        racingContest.playGame();
        winners = racingContest.returnWinner();
        for(String winner:winners){
            result = result.concat(winner)
                    .concat(", ");
        }
        result = result.substring(0, result.length()-2);
        System.out.println(result);
    }
}

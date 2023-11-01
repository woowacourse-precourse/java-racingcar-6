package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        RacingContest racingContest;
        List<String> winners;
        String result = "최종 우승자 : ";

        //input
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String players = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());

        //경기 횟수가 1회보다 적을 경우 수행할 수 없기 때문에 Exception
        if(round<1) {
            throw new IllegalArgumentException();
        }
        racingContest = new RacingContest(round);

        for(String racingCar :players.split(",")){
            //사용자가 자동차 이름을 입력하지 않았거나 5글자보다 많이 입력한 경우 Exception
            if(racingCar.length()==0||racingCar.length()>5){
                throw new IllegalArgumentException();
            }

            racingContest.insertCar(new RacingCar(racingCar));
        }

        //경기 시작 및 승자 확인
        System.out.println("실행 결과");
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

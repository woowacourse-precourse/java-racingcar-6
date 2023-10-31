package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RaceBefore;
import racingcar.domain.RaceEnd;
import racingcar.domain.RaceStart;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceBefore carGenerator = new RaceBefore();
        Map<String, Integer> car = carGenerator.carName();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.valueOf(readLine());

        int cnt = 1;
        System.out.println("\n실행 결과");
        //게임 시작
        while(cnt <= tryNumber){
            for(String s : car.keySet()){
                int random = Randoms.pickNumberInRange(0, 9);
                RaceStart.forwardDecision(car, random, s);
            }
            RaceStart.showResult(car);
            cnt++;
        }

        RaceEnd raceEnd = new RaceEnd();
        StringBuilder winnerList = raceEnd.winnerResult(car);

        System.out.print("최종 우승자 : " + winnerList);
    }
}

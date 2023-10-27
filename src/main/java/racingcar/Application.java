package racingcar;

import racingcar.domain.RaceBefore;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceBefore carGenerator = new RaceBefore();
        Map<String, Integer> car = carGenerator.carName();

        int tryNumber = Integer.valueOf(readLine());
        int cnt = 0;
        //게임 시작
        while(cnt <= tryNumber){

        }


    }
}

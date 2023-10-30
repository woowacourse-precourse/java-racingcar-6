package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing();

        // 입력 받기
        // 경주할 자동차 이름
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.asList(Console.readLine().split(","));
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        // 횟수
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());


    }

    public static void racing(){

        // 레이싱 게임 진행
        // 각 차수별 실행결과 출력
    }
    public static void end(){

        // 최종우승자 계산
        // 최종우승자 출력
        // 단독우승일 경우, 공동우승일 경우 나눠서 출력
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
public class Application {

    public static void main(String[] args) {
        InitData initData = getInitData();

        // TODO : 레이싱과정 출력 , 결과값 추출


    }

    private static InitData getInitData() {
        System.out.println("경주 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        // TODO : 차이름 검증

        System.out.println("시도할 회수는 몇회 인가요?");
        int tryCount = 0;
        // TODO : 시도횟수 받기
        int[] distanceArray = new int[carNames.length];
        System.out.println();
        InitData initData = new InitData(carNames, tryCount, distanceArray);
        return initData;
    }

    private record InitData(String[] carNames, int tryCount, int[] distanceArray) {

    }

}

package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Player;
import racingcar.domain.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 경기할 자동차 이름을 입력받고, 경기를 진행할 RacingCar 객체 생성
        RacingCar racingCar = new RacingCar(inputPlayers());

        // 시행 횟수를 입력 받는다
        int num = inputNumber();

        // 경기 실행
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            racingCar.run();
            System.out.println();
        }

        // 최종 우승자 출력
        racingCar.printWinner();
    }

    public static int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");

        int num = 0;
        try {
            num = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
        }

        if (num <= 0) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 1 이상의 자연수를 입력해 주세요");
        }

        return num;
    }

    public static List<Player> inputPlayers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Player> players = new ArrayList<>();
        /*
        * 이름을 "," 를 기준으로 나눠 반복해서 처리
        * */
        for (String name : camp.nextstep.edu.missionutils.Console.readLine().split(",", -1)) {
            // 이름이 조건에 맞으면, player List에 추가
            if(validateName(name)){
                players.add(new Player(name));
            }
        }

        return players;
    }

    public static boolean validateName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 비어있습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름이 5글자가 넘습니다.");
        }

        if(name.contains(" ")){
            throw new IllegalArgumentException("유효하지 않은 입력입니다, 이름에는 스페이스 바가 들어갈 수 없습니다.");
        }

        return true;
    }
}

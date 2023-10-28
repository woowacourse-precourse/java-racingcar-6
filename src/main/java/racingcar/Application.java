package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();

        // 자동차 이름 파싱 후 저장

        System.out.println("시도할 회수는 몇회인가요?");

        Integer repeatCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        // 전진 시도 시행 (실행결과 출력)

        String winners = "sample_winners";

        System.out.printf("최종 우승자 : %s", winners);
    }
}

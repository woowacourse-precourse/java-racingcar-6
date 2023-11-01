package racingcar;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        input = input.trim();

        String[] carNames = input.split(",");

        for (String value : carNames) {
            if (value.trim().length() > 5) {
                throw new IllegalArgumentException("길이가 5 이상인 값이 감지되었습니다: " + value);
            }
        }

        System.out.print("시도할 회수는 몇회인가요?");
        int raceCount = scanner.nextInt();

        if (raceCount <= 0) {
            throw new IllegalArgumentException("횟수는 양수여야 합니다.");
        }

        for (String carName : carNames){
            int moveCnt = 0;
            for (int i=0; i<raceCount; i++){
                int threshold = Randoms.pickNumberInRange(0,9);
                if (threshold >= 4){
                    moveCnt++;
                }
            }
        }

    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void stopOrForword(int carNum, int randomNum) {
        if (randomNum >= 4) {
            carScore.set(carNum, carScore.get(carNum) + 1);
        }
    }

    // 자동차별로 점수를 저장할 변수
    static List<Integer> carScore = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 이름 쉼표로 구분하여 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strName = Console.readLine();
        String[] sepStr = strName.split(",");
        List<String> carName = new ArrayList<>();

        // 이름이 6자 이상인 경우 예외 발생
        for (int i = 0; i < sepStr.length; i++) {
            if (sepStr[i].length() <= 5) {
                carName.add(sepStr[i]);
            } else {
                throw new IllegalArgumentException("5자 이하로 입력하세요.");
            }
        }

        // 이동할 횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        String strNum = Console.readLine();
        System.out.println();
        System.out.println("실행 결과");

        // 이동할 횟수가 숫자가 아닌 경우 예외 발생
        for (int i = 0; i < strNum.length(); i++) {
            if (!Character.isDigit(strNum.charAt(i))) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
        }
        int moveNum = Integer.parseInt(strNum);

        // 자동차 점수 0으로 초기화
        for(int i = 0; i < carName.size(); i++) {
            carScore.add(0);
        }

        // 0 ~ 9 사이의 무작위 값 구하기
        for (int i = 0; i < moveNum; i++) {
            for (int j = 0; j < carName.size(); j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                // 4 이상일 경우 전진(자동차 점수 1 증가)
                stopOrForword(j, randomNum);
            }
            // 실행결과 출력하기
            for (int j = 0; j < carName.size(); j++) {
                System.out.println(carName.get(j) + " : " + "-".repeat(carScore.get(j)));
            }
            System.out.println();
        }

    }
}

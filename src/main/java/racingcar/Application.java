package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 경주할 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] racingCar = carName.split(",");
        int racingCarCount = (int) Arrays.stream(racingCar).count();
        // 이름을 아예 입력하지 않았을 경우(바로 Enter 눌렀을 때), 쉼표를 잘못 사용한 경우
        for (int n=0; n<racingCarCount; n++) {
            if ((racingCar[n] == "") || (racingCar[n] == " ")) {
                throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
            }
        }
        if (racingCar[0] == "") {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 공백이 포함된 경우
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("공백을 제외하고 입력해주세요.");
        }
        // ,,를 쓴 경우
        if (carName.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 이름 하나 당 5자 초과할 때
        for (int m=0; m<racingCarCount; m++) {
            if (racingCar[m].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
        // 맨 마지막이 쉼표(,)로 끝났을 경우
        if (carName.length() == carName.lastIndexOf(",")+1) {
            throw new IllegalArgumentException("자동차 이름을 올바르게 입력해주세요.");
        }
        // 값을 10개 이상 넣었을 경우(최대 9개까지만 가능 -> 콘솔창이 밑으로 너무 늘어나기 때문에 다음과 같이 설정)
        if (racingCarCount > 9 ) {
            throw new IllegalArgumentException("자동차 이름은 최대 9개까지 설정 가능합니다.");
        }
        // 이름 중복의 경우
        String[] overLap = Arrays.stream(racingCar).distinct().toArray(String[]::new);
        if (overLap.length != racingCarCount) {
            throw new IllegalArgumentException("자동차 이름이 중복되어 있습니다.");
        }

        // 자동차가 전진을 시도하는 횟수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        System.out.println("");
        // 시도 횟수를 입력하지 않았을 경우(바로 Enter 눌렀을 때), 빈칸, 문자, 소수값이 있을 때 혹은 포함했을 때
        int attempt;
        try {
            attempt = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바른 숫자 입력 후 Enter를 눌러주세요.");
        }
        // 0일 때
        if (attempt == 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수로 입력해주세요.");
        }
        // 음의 정수일 때
        if (inputNumber.contains("-")) {
            throw new NumberFormatException("시도 횟수는 양의 정수를 입력해주세요.");
        }
        // 입력값이 너무 클 경우(최대 200까지만 가능 -> 콘솔창이 좌우로 너무 늘어나기 때문에 다음과 같이 설정)
        if (attempt > 200) {
            throw new IllegalArgumentException("시도 횟수는 최대 200까지 입력할 수 있습니다.");
        }

        // 진행 상황을 표시할 하이픈(-) 생성
        String carMove = "-";

        // 진행 상황 배열 생성
        String racingCarProgress [] = new String [racingCarCount];
        Arrays.fill(racingCarProgress, "");

        // 실행 결과 출력
        System.out.println("실행 결과");
        String carProgress = "";
        for (int i=0; i<attempt; i++) {
            for (int j=0; j<racingCarCount; j++) {
                System.out.print(racingCar[j] + " : ");
                // 무작위 값 구하기
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    racingCarProgress[j] += carMove;
                }
                System.out.println(racingCarProgress[j]);
            }
            System.out.println();
        }

        // 우승자 출력
        int fastCar=0;
        List<String> winnerCar = new ArrayList<>();
        for (int j=0; j<racingCarCount; j++) {
            int carProgressTotal = racingCarProgress[j].length();
            if (carProgressTotal > fastCar) {
                fastCar = carProgressTotal;
                winnerCar.clear();
                winnerCar.add(racingCar[j]);
            } else if (carProgressTotal == fastCar) {
                winnerCar.add(racingCar[j]);
            }
        }
        String winner = String.join(",",winnerCar);
        System.out.println("최종 우승자 : " + winner);
    }
}
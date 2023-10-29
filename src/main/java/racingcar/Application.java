package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    
    // 게임 진행을 위해 자동차의 위치를 저장할 HashMap 선언
    private static final HashMap<String, Integer> carState = new HashMap<>();

    // HashMap에 자동차 이름과 위치를 0으로 초기 상태 지정
    public static void initializeCarState(String[] carNames) {
        for (String name : carNames) {
            carState.put(name, 0);
        }
    }
    
    // 자동차 이름이 5글자가 넘는 경우 예외 처리로 프로그램 종료
    public static void checkCarNameLength(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 자동차 전진 혹은 정지
    // - 랜덤한 숫자 생성 후 4 이상일 경우 해당 자동차의 위치 1 증가
    public static void moveForwardCars() {
        for(String carName : carState.keySet()) {
            int currentPosition = carState.get(carName);
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                carState.put(carName, currentPosition + 1);
            }
        }
    }

    // 실행 결과 출력
    public static void printRacingResult() {
        for(String carName : carState.keySet()) {
            int currentPosition= carState.get(carName);

            System.out.print(carName + " : ");
            for (int i = 0; i < currentPosition; i++) {
                System.out.print("-");
            }

            System.out.println();
        }
        System.out.println();
    }


    // 우승자 출력
    public static void printWinner() {

        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for(String carName : carState.keySet()) {
            int currentPosition = carState.get(carName);
            if (maxPosition < currentPosition)
                maxPosition = currentPosition;
        }

        for(String carName : carState.keySet()) {
            int currentPosition = carState.get(carName);
            if (maxPosition == currentPosition)
                winners.add(carName);
        }

        System.out.print("최종 우승자 : ");
        String winner = String.join(", ", winners);
        System.out.print(winner);
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현


        // 사용자로부터 자동차 이름 입력을 받는 부분
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        String[] carNameArr = carNames.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = Integer.parseInt(readLine());


        // 사용자 입력 확인
        checkCarNameLength(carNameArr);

        // CarState에 초기화
        initializeCarState(carNameArr);

        System.out.println("실행 결과");

        // 시도 횟수 만큼 레이싱 게임 진행과 결과 출력
        for(int i = 0; i < attempts; i++) {
            moveForwardCars();
            printRacingResult();
        }

        printWinner();
    }
}

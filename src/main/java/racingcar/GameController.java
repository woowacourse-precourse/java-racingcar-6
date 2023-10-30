package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

/*
    게임 진행에 필요한 메서드 구현
    - 안내 문구 출력
        1. 경주할 자동차 이름
        2. 시도 횟수 입력
        3. 실행 결과 출력
        4. 최종 우승자 출력
    - 데이터 처리
        1. 자동차 무작위 전진
        2. 시도 횟수 만큼 전진 후 우승자 판별
        3.
 */
class GameController {
    GameData gameData = new GameData();

    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        gameData.setCars(Console.readLine());
    }

    public void inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameData.setTryCount(Integer.parseInt(Console.readLine()));
    }

    public void randomCarMove() {
        for (Map.Entry<String, String> car : gameData.getCarInfo().entrySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                gameData.moveCar(car.getKey());
            }
            System.out.println(car.getKey() + " : " + car.getValue());
        }
    }

    public void carRacing() {
        for (int repeat = 0; repeat < gameData.tryCount; repeat++) {
            randomCarMove();
            System.out.println();
        }
    }

    public void displayWinner() {
        System.out.println("최종 우승자 : " + gameData.getWinner());
    }
}
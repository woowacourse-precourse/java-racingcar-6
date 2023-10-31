package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

public class Application {
    static final int NAME_LENGTH_LIMIT = 5;
    static String[] carName;
    static String round;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getInput();
        List<RacingCar> carArray = new ArrayList<RacingCar>();
        carSetting(carArray);
        // 가장 멀리간 차의 거리를 반환 받음
        int distance = startGame(carArray);
        printWinner(carArray, distance);
    }

    public static void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = Console.readLine().split(",");
        checkWrongName(carName);

        System.out.println("시도할 회수는 몇회인가요?");
        round = Console.readLine();
        checkWrongRound(round);
    }

    public static void carSetting(List<RacingCar> carArray) {
        for (String name : carName) {
            carArray.add(new RacingCar(name));
        }
    }

    public static int startGame(List<RacingCar> carArray) {
        int maxDistance = 0;
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(round) - 1; i++) {
            for (RacingCar car : carArray) {
                car.moveForward(Randoms.pickNumberInRange(0, 9));
            }
            System.out.println();
        }
        // 가장 많이 간 거리를 체크하기 위해 마지막 반복문은 따로 돌게했다.
        for (RacingCar car : carArray) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
            if (maxDistance < car.step) {
                maxDistance = car.step;
            }
        }
        System.out.println();
        return maxDistance;
    }

    public static void printWinner(List<RacingCar> carArray, int maxDistance) {
        int index;
        System.out.printf("최종 우승자 : ");
        for (index = 0; index < carArray.size(); index++) {
            if (carArray.get(index).step == maxDistance) {
                System.out.printf(carArray.get(index).name);
                break;
            }
        }
        for (int i = index + 1; i < carArray.size(); i++) {
            if (carArray.get(i).step == maxDistance) {
                System.out.printf(", " + carArray.get(i).name);
            }
        }
    }

    public static void checkWrongName(String[] carName) {
        for (String name : carName) {
            if (name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkWrongRound(String round) {
        // 빈 문자열인 경우 예외처리
        if (round.isEmpty()){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        for (char c : round.toCharArray()) {
            if (c < 48 || c > 57) {
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
        }
    }
}

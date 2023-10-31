package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = inputCarName();
        // carNames 출력
        for (String carName : carNames) {
            System.out.println(carName);
        }
    }
    //자동차 이름 입력 받는 메소드
        public static String[] inputCarName() {
                System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String[] carNames = Console.readLine().split(",");
                return carNames;
        }
        public static int inputTryCount() {
                System.out.print("시도할 회수는 몇회인가요?");
                int tryCount = Integer.parseInt(Console.readLine());
                return tryCount;
        }
        //자동차 전진 여부 결정하는 메소드
        public static boolean moveState() {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                return randomValue >= 4;
        }
        // 자동차 전진 여부에 따라 자동차 위치를 변경하는 메소드
        public static int moveCar(int position, boolean moveState) {
                if (moveState) {
                        position++;
                }
                return position;
        }
        // 자동차 위치를 출력하는 메소드
        public static void printCarPosition(String[] carName, int position) {
                System.out.print(carName + " : ");
                for (int i = 0; i < position; i++) {
                        System.out.print("-");
                }
                System.out.println();
        }

}


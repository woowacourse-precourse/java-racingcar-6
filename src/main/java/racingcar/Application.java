package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int randoms = 0;

        System.out.print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        String input = Console.readLine(); //각 자동차에 이름을 부여할 수 있다. 
        String[] carNames = input.split(","); //자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        for (String carName : carNames) {
            if (carName.length() > 5) {  //이름은 5자 이하만 가능하다.
                throw new IllegalArgumentException("자동차 이름 입력 오류"); //사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
            }
        }

        System.out.print("시도할 회수는 몇 회인가요? \n");
        String userInput = Console.readLine().trim();   //사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
        int number = Integer.parseInt(userInput);
        

        runSimulation(carNames, number, randoms);
    }

    public static void runSimulation(String[] carNames, int numAttempts, int randoms) {
        int numCars = carNames.length;
        int[] carPositions = new int[numCars];
        System.out.println("\n실행 결과");
        for (int attempt = 1; attempt <= numAttempts; attempt++) {
            System.out.println("\n");
            for (int i = 0; i < numCars; i++) {
                randoms = Randoms.pickNumberInRange(0, 9);
                int move = (randoms >= 4) ? 1 : 0; // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
                carPositions[i] += move;
                printCarStatus(carNames[i], carPositions[i]);
            }
        }

        determineWinners(carNames, carPositions);
    }

    public static void printCarStatus(String carName, int position) {
        StringBuilder status = new StringBuilder(carName + " : ");
        for (int i = 0; i < position; i++) {
            status.append("-");
        }
        System.out.println(status.toString());//전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    }

    public static void determineWinners(String[] carNames, int[] carPositions) {
        int maxPosition = 0;
        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (carPositions[i] > maxPosition) {
                maxPosition = carPositions[i];
                winners = new StringBuilder(carNames[i]);
            } else if (carPositions[i] == maxPosition) {
                winners.append(", ").append(carNames[i]); //우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
            }
        }

        System.out.println("최종 우승자 : " + winners.toString()); //자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    }
}

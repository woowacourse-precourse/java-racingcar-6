package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
            String Input = getInput();
            // 기능 2-1. 자동차의 이름을 저장하여 각 라운드마다 자동차의 이름과 진행 상황을 프린트하는 함수인 playRound() 메서드 구현
            // 기능 3-1. 자동차 이름을 쉼표를 기준으로 구분하여 저장
            String[] cars = Input.split(",");
            validCars(cars);
            // 기능 1-2. 주어진 횟수를 입력받기(몇 번의 라운드를 진행할 지 입력 받기)
            int rounds = getNumberOfRounds();
            // 기능 4-1. 사용자에게 몇 라운드를 진행할 것인지 입력하게 하고 기능8에 따라서 숫자가 아니거나 1이상의 정수를 입력하지 않은 경우 IllegalArgumentException을 발생
            validRound(rounds);
            // 자동차의 수 X 라운드의 수 만큼 0을 초기값으로 갖는 배열 생성
            int[][] location = saveLocation(cars, rounds);
            System.out.println("\n실행 결과");
            // 기능 5-1. 입력 받은 라운드 수만큼 전진할지 정지할지 결정하여 int[][] location에 저장하고 매 라운드마다 자동차별 진행 상황 프린트
            for(int round = 0; round < rounds; round++ ){
                    playRound(cars, rounds, location);
            }
            // 기능 6-1. 기능 7을 고려하여 우승자가 여럿일 경우 쉼표를 이용해 구분하여 출력하는 기능을 printWinner와 getWinners 함수로 구현
            printWinner(cars, rounds, location);
    }

    // 기능 1-1. 자동차의 이름을 입력 받아 몇 대(n)의 자동차로 경기를 할 것인지 입력 받기
    public static String getInput(){
            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            return input;
    }

    // 기능 3-2. 자동차 이름을 2개 이상 입력하지 않았거나 이름의 길이가 0이거나 5자 초과인 경우 기능 8에 따라 IllegalArgumentException 발생
    public static void validCars(String[] cars){
            if (cars.length < 2){
                System.out.println("경기를 위해서는 2대 이상의 자동차가 필요합니다.");
                throw new IllegalArgumentException();
            }
            for (String car : cars) {
                if (car.isEmpty()){
                    System.out.println("자동차 이름이 공란이어서는 안됩니다.");
                    throw new IllegalArgumentException();
                }
                if(car.length() > 5) {
                    System.out.println("자동차 이름이 5자를 초과해서는 안됩니다.");
                    throw new IllegalArgumentException();
                }
            }
    }

    // 기능 1-2. 주어진 횟수를 입력받기(몇 번의 라운드를 진행할 지 입력 받기)
    public static int getNumberOfRounds(){
            System.out.print("시도할 회수는 몇회인가요?");
            Scanner scanner = new Scanner(System.in);
            int rounds = Integer.parseInt(Console.readLine());
            scanner.close();
            return rounds;
    }
    // 기능 5-1. 입력 받은 라운드 수만큼 전진할 지 정지할 지 결정하여 int[][] location에 저장하고 매 라운드마다 자동차 별 진행 상황 프린트
    public static int[][] saveLocation(String[] cars, int rounds) {
            int numOfCars = cars.length;
            int[][] location = new int[numOfCars][rounds];

            // 각 자동차에 대하여 매 라운드마다 랜덤하게 수를 생성하여 규칙에 따라 전진하면 1을 정지하면 0을 location에 저장
            for (int n = 0; n < numOfCars; n++){
                    for (int r = 0; r < rounds; r++){
                            int random = Randoms.pickNumberInRange(0, 9);
                            if (random >= 4){
                                location[n][r] = 1;
                            }
                            location[n][r] = 0;
                    }
            }
            return location;
    }

    // 기능 2-1. 자동차의 이름을 저장하여 각 라운드마다 자동차의 이름과 진행 상황을 프린트하는 함수인 playRound() 메서드 구현
    // 기능 5-1. 입력 받은 라운드 수만큼 전진할지 정지할지 결정하여 int[][] location에 저장하고 매 라운드마다 자동차별 진행 상황 프린트
    public static void playRound(String[] cars, int rounds, int[][] location){
            int numOfCars = cars.length;
            int index = 0;

            for (String car : cars) {
                    index += 1;
                    System.out.print(car + ": ");
                    for(int i = 0; i < rounds; i++){
                            if(location[index][i] == 1){
                                    System.out.print("-");
                            }
                    }
                    System.out.println();
            }
    }

    // 기능 4-1. 사용자에게 몇 라운드를 진행할 것인지 입력하게 하고 기능8에 따라서 숫자가 아니거나 1이상의 정수를 입력하지 않은 경우 IllegalArgumentException을 발생
    public static void validRound(int rounds) {
            if (rounds <= 0) {
                throw new IllegalArgumentException("1이상의 정수를 입력해주세요.");
            }
    }

    // 기능 6-1. 기능 7을 고려하여 우승자가 여럿일 경우 쉼표를 이용해 구분하여 출력하는 기능을 printWinner와 getWinners 함수로 구현
    public static void printWinner(String[] cars, int rounds, int[][] location) {
            System.out.println("\n최종 우승자: " + getWinners(cars, rounds, location));
    }
    // 기능 6-1. 기능 7을 고려하여 우승자가 여럿일 경우 쉼표를 이용해 구분하여 출력하는 기능을 printWinner와 getWinners 함수로 구현
    public static String getWinners(String[] cars, int rounds, int[][] location){
            int numOfCars = cars.length;
            StringBuilder winners = new StringBuilder();
            int maxPosition = -1;
            for (int i = 0; i < numOfCars; i++) {
                    int finalPosition = 0;
                    for (int round = 0; round < rounds; round++){
                            finalPosition += location[i][round];
                    }
                    maxPosition = Math.max(maxPosition, finalPosition);
            }

            for (int index = 0; index < numOfCars; index++) {
                    if (location[index][rounds - 1] == maxPosition) {
                            if (!winners.isEmpty()) {
                                    winners.append(", ");
                            }
                            winners.append(cars[index]);
                    }
            }
            return winners.toString();
    }
}

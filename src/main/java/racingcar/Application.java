package racingcar;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) ");
        String[] carNames = scanner.nextLine().split(",");

        System.out.print("시도할 회수는 몇회인가요? ");
        int rounds = scanner.nextInt();

        Race race = new Race(carNames, rounds);
        race.start();
    }
}

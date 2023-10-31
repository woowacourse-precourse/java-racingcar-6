package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    // move 조건 설정
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }
}

public class Application {
    List<Car> racerList = new ArrayList<>();

    public void checkNamelength(String[] racerArray) {
        for (int i = 0; i < racerArray.length; i++) {
            // name의 길이가 5를 넘어가는 경우 -> 예외 발생
            if (racerArray[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            racerList.add(new Car(racerArray[i]));
        }
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : racerList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : racerList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void tryRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : racerList) {
                car.move();
                System.out.printf("%s : ", car.getName());
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            // 2명 이상이 되는 경우 ", "를 포함하여 출력하도록 설정
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }


    public void racing() {
        // 경주 할 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racerNames = Console.readLine();
        // ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
        String[] racerArray = racerNames.split(",");
        checkNamelength(racerArray);
        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        tryRace(tryCount);

        int maxPosition = findMaxPosition();    // 제일 멀리 간 position 확인
        List<String> winners = findWinners(maxPosition);
        printWinner(winners);   // 최종 우승자 출력
    }

    public static void main(String[] args) {
        Application race = new Application();
        race.racing();
    }
}

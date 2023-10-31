package racingcar;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 자동차 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = scanner.nextLine();
        String[] carNames = carNamesInput.split(",");

        // 입력받은 자동차 이름의 길이가 5자를 초과하는지 확인
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        // 사용자로부터 경주 횟수를 입력받음
        System.out.println("시도할 회수는 몇회인가요?");
        int races = scanner.nextInt();
        scanner.nextLine();

        // Car 객체를 생성하여 리스트에 추가
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        // 경주 실행 결과를 출력
        System.out.println("\n실행 결과");
        for (int i = 0; i < races; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getDistanceCovered());
            }
            System.out.println();
        }

        // 우승자를 결정하고 출력
        List<String> winners = getWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    // 우승자를 결정
    public static List<String> getWinners(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    // Car 클래스: 자동차의 이름과 거리를 관리
    static class Car {
        private String name;
        private int distance;

        public Car(String name) {
            this.name = name;
            this.distance = 0;
        }

        // 무작위로 자동차를 움직이는 메소드 (4 이상일 때만 전진)
        public void move() {
            Random random = new Random();
            if (random.nextInt(10) >= 4) {
                distance++;
            }
        }

        // 자동차의 이동 거리를 문자열로 변환하는 메소드
        public String getDistanceCovered() {
            StringBuilder distanceCovered = new StringBuilder();
            for (int i = 0; i < distance; i++) {
                distanceCovered.append("-");
            }
            return distanceCovered.toString();
        }

        // 자동차의 이름을 반환하는 메소드
        public String getName() {
            return name;
        }

        // 자동차의 이동 거리를 반환하는 메소드
        public int getDistance() {
            return distance;
        }
    }
}

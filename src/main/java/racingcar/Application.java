package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private List<Car> cars = new ArrayList<>();
    private int attempts;

    //시작
    public void start() {
        initCars();
        initAttempts();
        race();
        printWinners();
    }

    //차량 이름 입력
    private void initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            validateName(carName);
            cars.add(new Car(carName));
        }
    }

    //자동차 이름 조건 (5글자 이하)
    private void validateName(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Car name should be less than 5 characters.");
        }
    }

    //시도 횟수 입력
    private void initAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        attempts = Integer.parseInt(Console.readLine());
    }

    //1회 실행. (랜덤값 설정)
    private void race() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
                System.out.println(car.getName() + " : " + car.getDisplayDistance());
            }
            System.out.println();
        }
    }

    //최종 우승자 출력(동순위도)
    private void printWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    //최대 이동 거리를 구함
    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public static class Car {
        private String name;
        private int distance = 0;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }

        //이동한걸 시각적으로 보여주기 위해 해당 메소드 작성
        public String getDisplayDistance() {
            StringBuilder displayDistance = new StringBuilder();
            for (int i = 0; i < distance; i++) {
                displayDistance.append("-");
            }
            return displayDistance.toString();
        }

        //랜덤 값이 4이상일 경우 distance 증가(이동)
        public void move(int randomNumber) {
            if (randomNumber >= MOVE_THRESHOLD) {
                distance++;
            }
        }
    }

    public static void main(String[] args) {
        new Application().start();
    }
}


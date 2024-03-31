package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 자동차 클래스
class Car {
    private String name;
    private int position;

    // 생성자
    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
    }

    // 이름 유효성 검사 메소드
    private String validateName(String name) {
        try {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자까지 가능합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.exit(0); // 유효하지 않은 입력일 경우 프로그램 종료
        }
        return name;
    }

    // 자동차 이동 메소드
    public void move() {
        final int MOVING_FORWARD = 4;

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVING_FORWARD) {
            this.position++;
        }
    }

    // 자동차 이름 반환 메소드
    public String getName() {
        return this.name;
    }

    // 자동차 위치 반환 메소드
    public int getPosition() {
        return this.position;
    }
}

// 애플리케이션 클래스
public class Application {
    private static final int MOVING_FORWARD = 4;

    // 메인 메소드
    public static void main(String[] args) {

        // 자동차 이름 입력 및 리스트 초기화
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        // 입력받은 자동차 이름으로 자동차 객체 생성
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        // 시도할 회수 입력
        System.out.println("시도할 회수는 몇회인가요? ");
        int tryCount = Integer.parseInt(Console.readLine());

        // 실행 결과 출력
        System.out.print("\n실행 결과\n");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        // 누가 우승자 인지가려냄
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        // 우승자 확인
        if (winners.size() > 1) {
            System.out.print("최종 우승자: ");
            for (int i = 0; i < winners.size(); i++) {
                if (i == winners.size() - 1) {
                    System.out.print(winners.get(i));
                } else {
                    System.out.print(winners.get(i) + ", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("최종 우승자 : " + winners.get(0));
        }

    }
}

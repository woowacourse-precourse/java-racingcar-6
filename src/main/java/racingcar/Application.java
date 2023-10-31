package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {

    //Car 클래스 정의
    public static class Car {
        public String name;
        public int RandomNumber; // 랜덤으로 받을 정수
        public int AdvanceCount = 0; // 전진 횟수

        public Car(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 자동차 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String Input = Console.readLine();
        String[] carNames = Input.split(","); // 쉼표로 자르기

        // 시도 횟수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());

        //자동차 객체 생성
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < 3; i++) {
            cars[i] = new Car(carNames[i] + " : ");
            //System.out.println(cars[i].getName());
        }

        // 결과 출력
        System.out.println("실행 결과");
        displayResult(tries, cars);
    }

    public static void displayResult(int tries, Car[] cars) {
        for (int i = 0; i < tries; i++) { // 시도 횟수 만큼 반복
            for (int j = 0; j < cars.length; j++) { // 차 개수 만큼 반복
                cars[j].RandomNumber = Randoms.pickNumberInRange(0, 9); // 랜덤한 숫자 할당
                if (cars[j].RandomNumber > 4) { // 4 이상시
                    cars[j].AdvanceCount++; // 전진
                    cars[j].name = cars[j].name.concat("-");
                }
            }
            for (Car car : cars) {
                System.out.println(car.name);
            }
            System.out.println();
        }

        System.out.println("촤종 우승자 : ");
    }
}


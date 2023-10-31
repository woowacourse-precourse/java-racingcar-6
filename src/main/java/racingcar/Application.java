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

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        // 시도 횟수 입력 받기
        System.out.println("시도할 회수는 몇회인가요?");
        int tries = Integer.parseInt(Console.readLine());

        if (tries < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }

        //자동차 객체 생성
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i] + " : ");
            //System.out.println(cars[i].getName());
        }

        System.out.println("실행 결과");
        StartRacing(tries, cars);
        FinalWinner(cars, carNames);

    }

    // 경주 시작
    public static void StartRacing(int tries, Car[] cars) {
        for (int i = 0; i < tries; i++) { // 시도 횟수 만큼 반복
            for (int j = 0; j < cars.length; j++) { // 차 개수 만큼 반복
                cars[j].RandomNumber = Randoms.pickNumberInRange(0, 9); // 랜덤한 숫자 할당
                if (cars[j].RandomNumber > 3) { // 4 이상시
                    cars[j].AdvanceCount++; // 전진
                    cars[j].name = cars[j].name.concat("-");
                }
            }
            for (Car car : cars) {
                System.out.println(car.name);
            }
            System.out.println();
        }
    }

    public static void FinalWinner(Car[] cars, String[] carNames) {

        // AdvanceCount 최댓값 찾기
        int max = cars[0].AdvanceCount; // 초기값

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].AdvanceCount >= max) {
                max = cars[i].AdvanceCount;
            }
        }

        System.out.print("최종 우승자 :"); // 1등 출력

        boolean isFirstWinner = true; // 첫 번쨰 우승자인지 확인하기 위한 변수

        // max와 값이 같은 자동차를 공동 우승자로 포함시키기
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].AdvanceCount == max) {
                if (!isFirstWinner) {
                    System.out.print(", "); // 첫 번쨰 우승자가 아닐 경우 콤마 출력
                }
                System.out.print(" " + carNames[i]);
                isFirstWinner = false; // 첫 번쨰 우승자가 아니라고 표ㅕ시

            }
        }

    }
}


package racingcar;

import java.util.*;

// 효율적인 구현을 위한 Class 정의
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
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            position++;
        }
    }
}



public class Application {
    private Scanner scanner;
    List<Car> racerList = new ArrayList<>();

    public void checkNamelength(String[] racerArray){
        for (int i = 0; i < racerArray.length; i++) {
            // name의 길이가 5를 넘어가는 경우 -> 예외 발생
            if (racerArray[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            racerList.add(new Car(racerArray[i]));
        }
    }

    public int findMaxPosition(){
        int maxPosition = 0;
        for (Car car : racerList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


    public void racing() {
        scanner = new Scanner(System.in);
        // Implement input
        // 경주 할 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racerNames = scanner.nextLine();
        // ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
        String[] racerArray = racerNames.split(",");
        checkNamelength(racerArray);    // racer들의 이름을 List<Stirng>에 저장
        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        System.out.println("실행 결과");
        for (int i=0; i < tryCount; i++){
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

        // 제일 멀리 간 position 확인
        int maxPosition = findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : racerList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
    public static void main(String[] args) {
        Application race = new Application();
        race.racing();
        race.scanner.close(); // 프로그램 종료 시 scanner를 닫아줍니다.
    }
}

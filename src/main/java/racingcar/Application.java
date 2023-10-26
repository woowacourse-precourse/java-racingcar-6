package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // given
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        ArrayList<Car> carList = new ArrayList<>();

        for (String name : inputNames.split(",")) {
            if(name.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int inputTimes = 0;
        try {
            inputTimes = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            System.out.println("[ERROR] 입력값이 잘못되었습니다.");
        }
        if(inputTimes <= 0) {
            throw new IllegalArgumentException();
        }

        // when
        System.out.println("실행 결과");
        while(inputTimes > 0) {
            for (Car car : carList) {
                System.out.print(car.getName());
                car.checkMovingForward();
                System.out.println(" : " + "-".repeat(car.getMovingforward()));
            }

            System.out.println();
            inputTimes--;
        }

        //then
        ArrayList<String> winners = new ArrayList<>();
        int max = 0;
        for(Car car: carList) {
            if(car.getMovingforward() == max) {
                winners.add(car.getName());
            }

            if(car.getMovingforward() > max) {
                max = car.getMovingforward();
                winners.clear();
                winners.add(car.getName());
            }
        }

        String result = String.join(", ", winners);

        System.out.println("최종 우승자 : " + result);
    }
}

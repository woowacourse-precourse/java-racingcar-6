package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputCar = Console.readLine();

        String[] CarList = InputCar.split(",");

        DriveCar[] driveCars = new DriveCar[CarList.length];

        for(int i = 0; i < CarList.length; i++){
            if(CarList[i].length() > 5) {
                throw new IllegalArgumentException("잘못된 입력.");
            }
            driveCars[i] = new DriveCar(CarList[i].trim(), 0);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        int num = Integer.parseInt(input);

        System.out.println("\n실행 결과");
        Race race = new Race(driveCars, num);
        race.Racing();
    }
}

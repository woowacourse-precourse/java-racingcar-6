package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        CarGenerator generator = new CarGenerator();
        Printer printer = new Printer();
        Referee referee = new Referee();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String enteredNames = readLine();
        if (!Validation.validNames(enteredNames))
            throw new IllegalArgumentException("영어와 쉼표로만 입력해주세요.");

        List<String> nameList = generator.splitNames(enteredNames);
        if (!Validation.validLength(nameList))
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 구성해주세요.");

        System.out.println("시도할 회수는 몇회인가요?");
        String enteredNumber = readLine();
        if (!Validation.validNumber(enteredNumber))
            throw new IllegalArgumentException("1회 이상의 횟수를 숫자로만 입력해주세요.");

        int numberOfTimes = Integer.parseInt(enteredNumber);
        List<Car> carList = generator.createCars(nameList);

        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTimes; i++) {
            for (Car car : carList) {
                car.move(Car.canMove());
            }
            printer.printDistance(carList);
            System.out.println();
        }

        int max = referee.findMaxDistance(carList);
        List<Car> winnerList = referee.findWinner(carList, max);

        System.out.print("최종 우승자 : ");
        printer.printWinner(winnerList);
    }
}

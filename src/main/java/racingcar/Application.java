package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        CarGenerator generator = new CarGenerator();
        Printer printer = new Printer();
        Referee referee = new Referee();
        InputManager inputManager = new InputManager();

        String enteredNames = inputManager.readNames();
        List<String> nameList = generator.splitNames(enteredNames);
        if (!Validation.validLength(nameList))
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 구성해주세요.");

        int numberOfTimes = inputManager.readNumberOfTimes();
        List<Car> carList = generator.createCars(nameList);

        System.out.println("\n실행 결과");
        runRace(printer, carList, numberOfTimes);

        int max = referee.findMaxDistance(carList);
        List<Car> winnerList = referee.findWinner(carList, max);

        System.out.print("최종 우승자 : ");
        printer.printWinner(winnerList);
    }

    public static void runRace(Printer printer, List<Car> carList, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            for (Car car : carList) {
                car.move(Car.canMove());
            }
            printer.printDistance(carList);
            System.out.println();
        }
    }
}

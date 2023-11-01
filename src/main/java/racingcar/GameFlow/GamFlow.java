package racingcar.GameFlow;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Domain.Car;
import racingcar.Domain.Judge;
import racingcar.Service.CarService;
import racingcar.Service.InputService;
import racingcar.Service.OutputService;

public class GamFlow {

    private static CarService carService=new CarService();
    private static InputService inputService=new InputService();
    private static OutputService outputService=new OutputService();
    private static Car car=new Car();
    private static Judge judge=new Judge();

    public void start() {
        outputService.printCarnameQuestion();
        String carname= Console.readLine();
        init(carname);
        String num = Console.readLine();
        System.out.println("실행결과 :");
        for (int i = 0; i < Integer.valueOf(num); i++) {
            outputService.printForwardStatus();
        }
        outputService.printWinner();

    }

    private static void init(String carname) {
        inputService.throwException(carname);
        inputService.inputCarname(carname);
        inputService.SplitCarname(carname);
        inputService.makeCarArray();
        outputService.printTryNumQuestion();
        judge.setCarservice(carService);
        judge.setInputService(inputService);
        outputService=new OutputService(carService,inputService,judge);
    }
}

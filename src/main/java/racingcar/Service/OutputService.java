package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Domain.Car;

public class OutputService {
    private static Car car;
    private static InputService inputService;

    public OutputService(Car car, InputService inputService) {
        this.inputService=inputService;
        this.car = car;
    }

    public static Car getCar() {
        return car;
    }

    public static void setCar(Car car) {
        OutputService.car = car;
    }

    public static InputService getInputService() {
        return inputService;
    }

    public static void setInputService(InputService inputService) {
        OutputService.inputService = inputService;
    }

    public String printCarnameQuestion() {
        String question = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(question);
        return question;
    }

    public String printTryNumQuestion() {
        String question = "시도할 회수는 몇회인가요?";
        System.out.println(question);
        return question;
    }

    public String printCar() {
        List<String> cars = inputService.getCars();
        String result = String.join(" :\n", cars);
        if (!cars.isEmpty()) {
            result += " :\n";
        }
        return result;
    }
}

package racingcar.Service;

import java.util.List;

public class OutputService {
    private static CarService car;
    private static InputService inputService;

    public OutputService(CarService car, InputService inputService) {
        this.inputService=inputService;
        this.car = car;
    }

    public static CarService getCar() {
        return car;
    }

    public static void setCar(CarService car) {
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
        List<String> cars = inputService.getCarNames();
        String result = String.join(" :\n", cars);
        if (!cars.isEmpty()) {
            result += " :\n";
        }
        return result;
    }

    public String printForwardStatus() {

        return null;

    }
}

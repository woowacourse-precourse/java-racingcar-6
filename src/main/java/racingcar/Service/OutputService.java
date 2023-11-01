package racingcar.Service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.Domain.Judge;

public class OutputService {
    private static CarService carService
            ;
    private static InputService inputService;

    private static Judge judge;

    public OutputService(CarService car, InputService inputService,Judge judge) {
        this.inputService=inputService;
        this.carService = car;
        this.judge=judge;
    }

    public static CarService getCarService() {
        return carService;
    }

    public static void setCarService(CarService carService) {
        OutputService.carService = carService;
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
        List<Car> cars = inputService.getCars();
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            appendCarStatus(result, car);
        }
        return result.toString();
    }

    private void appendCarStatus(StringBuilder result, Car car) {
        if (carService.forwardOrStop()) {
            car.getForwardStack().add("-");
        }
        result.append(car.getName())
                .append(" : ")
                .append(String.join("", car.getForwardStack()))
                .append("\n");
    }

    public String printWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        List<String> winners = judge.judgeWinner();
        if (winners.size() > 1) {
            sb.append(String.join(", ",winners));
        } else if (winners.size()==1) {
            sb.append(winners.get(0));
        }
        System.out.println(sb.toString());
        return sb.toString();

    }
}

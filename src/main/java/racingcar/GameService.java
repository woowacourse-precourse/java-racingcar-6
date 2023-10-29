package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameService {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String COUNT_QUERY_MESSAGE = "시도할 회수는 몇회인가요?";
    IOService ioService;

    public void start() {
        int count;

        System.out.println(START_MESSAGE);
        List<String> carNames = ioService.scanCarNames();
        List<Car> carList = createCarList(carNames);


    }

    private List<Car> createCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<Car>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private List<Car> selectWinners(List<Car> carList) {
        List<Car> winners;

        Car firstWinner = carList.stream().max(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getPos() - o2.getPos();
            }
        }).orElse(new Car("error", 0));


        winners = carList.stream()
                .filter((car) -> car.getPos() == firstWinner.getPos())
                .toList();

        return winners;
    }
}

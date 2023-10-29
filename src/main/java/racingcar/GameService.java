package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameService {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String COUNT_QUERY_MESSAGE = "시도할 회수는 몇회인가요?";

    private IOService ioService;

    public GameService() {
        this.ioService = new IOService();
    }

    public void start() {
        int count;

        System.out.println(START_MESSAGE);
        
        List<String> carNames = ioService.scanCarNames();
        List<Car> carList = createCarList(carNames);

        System.out.println(COUNT_QUERY_MESSAGE);
        count = ioService.scanCnt();

        System.out.println("실행 결과");

        for (int i = 0; i < count; ++i) {
            List<Integer> randomNumbers = NumberGenerator.createRandomNumbers(carList.size());
            process(carList, randomNumbers);
            ioService.printCarListState(carList);
        }

        List<Car> winnerCars = selectWinners(carList);
        List<String> winnerCarsName = winnerCars.stream()
                .map(Car::getName)
                .toList();

        ioService.printWinners(winnerCarsName);
    }

    private void process(List<Car> carList, List<Integer> randomNumbers) {
        for(int i = 0; i < carList.size(); ++i){
            if(randomNumbers.get(i) >= 4)
                carList.get(i).move();
        }
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

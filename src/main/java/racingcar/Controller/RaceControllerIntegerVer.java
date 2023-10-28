package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;
import racingcar.View.RaceView;

public class RaceControllerIntegerVer implements RaceController {

    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_START_RANGE = 0;
    private static final int MOVE_END_RANGE = 9;
    private static RaceView raceView;


    @Override
    public void processRace(String input, CarRepository carRepository) {

        raceRepeatByInput(input, carRepository);

        Map<Integer, List<Car>> rankingMap = PartitioningByRank(carRepository);
        List<Car> winnerCarList = getWinnerList(rankingMap);
        List<String> winners = ConvertCarToString(winnerCarList);

        raceView.printWinner(winners);
    }

    private void raceRepeatByInput(String input, CarRepository carRepository) {
        int round = Integer.parseInt(input);
        int size = carRepository.size();

        for (int i = 0; i < round - 1; i++) {
            for (int j = 0; j < size; j++) {
                Car car = carRepository.getCar(j);

                int randomNumber = pickRandomNumber();
                boolean canMove = randomNumber > MOVE_CRITERIA;
                car.move(randomNumber, canMove);

                raceView.print(car, randomNumber);
            }
            System.out.println();
        }
    }

    private static Map PartitioningByRank(CarRepository carRepository) {
        HashMap<Integer, List<Car>> map = new HashMap<>();
        int size = carRepository.size();
        for (int i = 0; i < size; i++) {
            Car car = carRepository.getCar(i);

            int position = car.getPosition();
            List<Car> samePositionList = map.getOrDefault(position, new ArrayList<>());
            samePositionList.add(car);
        }
        return map;
    }

    private static List getWinnerList(Map<Integer, List<Car>> rankMap) {
        return rankMap.keySet()
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .map(key -> rankMap.get(key))
                .get();


    }

    private static List ConvertCarToString(List<Car> winnerCarList) {
        return winnerCarList
                .stream()
                .map(car -> car.getCarName().getName())
                .toList();

    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MOVE_START_RANGE, MOVE_END_RANGE);
    }

    @Override
    public void validateRoundInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

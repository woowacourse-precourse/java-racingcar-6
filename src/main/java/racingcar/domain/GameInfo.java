package racingcar.domain;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.RacingCarView;

public class GameInfo {
    private final List<RacingCar> carList;
    private final int count;
    public List<RacingCar> getCarList(){
        return carList;
    }
    public int getCount(){
        return count;
    }
    public GameInfo(List<RacingCar> carList, int count){
        this.carList = carList;
        this.count = count;
    }
    public void printWinner(){
        int maxDistance = carList.stream()
            .mapToInt(car -> car.getDistance().length())
            .max()
            .orElse(0);

        List<String> winners = carList.stream()
            .filter(car -> car.getDistance().length() == maxDistance)
            .map(RacingCar::getName)
            .collect(Collectors.toList());

        String winnersNames = String.join(", ", winners);
        RacingCarView.printWinnerName(winnersNames);
    }


}

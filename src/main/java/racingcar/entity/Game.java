package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.IO.IOService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public Game(Integer playCount) {
        this.carList = carList;
    }

    private Long id;

    private List<Car> carList = new ArrayList<>();

    private Integer playCount;

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<String> getCarNameList() {
        return carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }


    public boolean carGoOrStop() {
        int pivot=4;
        int number= Randoms.pickNumberInRange(0, 9);
        if(number>=pivot) return true;
        return false;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void printResult() {
        List<String> winnerList = getWinner();
        String winners=String.join("", winnerList);
        IOService.printNotice(IOService.END,winners);
    }

    public  List<String> getWinner() {
        int maxScore = 0;
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getScore() < maxScore) {
                continue;
            }
            if (car.getScore() > maxScore) {
                maxScore = car.getScore();
                winnerList.clear();
                winnerList.add(car.getName());
                continue;
            }
            winnerList.add(car.getName());
        }
        return winnerList;
    }
}

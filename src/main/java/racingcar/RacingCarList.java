package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCarList(String input) {
        List<String> nameList = getNameListFromInput(input);
        createRacingCarListByNameList(nameList);
    }

    public void executeOneStep() {
        racingCarList.forEach(racingCar -> {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                racingCar.moveOneBlock();
            }
        });
    }

    public void printRacingCarsCurrentStatus() {
        racingCarList.forEach(racingCar -> racingCar.printCurrentResult());
    }

    public int getMaxForward() {
        return racingCarList.stream()
                .mapToInt(RacingCar::getCount)
                .max()
                .orElse(0);
    }

    public List<String> getWinnerList(int maxCount) {
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getCount() == maxCount)
                .map(RacingCar::getName)
                .toList();
    }

    private List<String> getNameListFromInput(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private void createRacingCarListByNameList(List<String> nameList) {
        nameList.forEach(name -> racingCarList.add(new RacingCar(name)));
    }


}

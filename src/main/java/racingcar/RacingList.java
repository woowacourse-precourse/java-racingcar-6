package racingcar;

import static racingcar.validate.RacingListValidator.duplicateValidate;
import static racingcar.validate.RacingListValidator.sizeValidate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingList {
    private static final int MOVING_FORWARD = 4;
    private final LinkedHashMap<String, Integer> carList = new LinkedHashMap<>();

    public void createData(String input) {
        String[] list = input.split(",");
        for (String s : list) {
            sizeValidate(s);
            duplicateValidate(carList, s);
            carList.put(s, 0);
        }
    }

    public void updateState() {
        for (String strKey : carList.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD) {
                Integer i = carList.get(strKey);
                i++;
                carList.replace(strKey, i);
            }
        }
    }

    public List<String> returnWinners() {
        return carList.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(
                        carList.values().stream().max(Integer::compareTo).orElse(null)
                ))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public LinkedHashMap<String, Integer> getCarList() {
        return carList;
    }

}

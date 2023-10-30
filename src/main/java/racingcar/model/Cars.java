package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ExceptionCheck;
import racingcar.view.OutputView;

public class Cars {

    private final List<CarModel> carModelList = new ArrayList<>();

    public Cars(List<String> carList) {
        for (String s : carList) {
            ExceptionCheck.nameLengthValidation(s);
            this.carModelList.add(new CarModel(s));
        }
    }

    public void forwardCars() {
        for (CarModel carModel : carModelList) {
            carModel.forward(Randoms.pickNumberInRange(0, 9));
            OutputView.printRacing(carModel.getName(), carModel.getLocation());
        }
        System.out.println("");
    }

    public List<CarModel> winner() {
        int maxLocation = maxLocation();

        return carModelList.stream()
            .filter(carModel -> carModel.getLocation() == maxLocation)
            .toList();
    }

    private int maxLocation() {
        return carModelList.stream()
            .mapToInt(CarModel::getLocation)
            .max()
            .getAsInt();
    }
}

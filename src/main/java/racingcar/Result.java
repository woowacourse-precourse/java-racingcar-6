package racingcar;

import java.util.List;

public class Result {

    List<StringBuilder> result;

    public Result(Cars cars) {
        List<Car> carList = cars.getCars();

        result = carList.stream()
                .map(car -> new StringBuilder(car.getCarName() + " : "))
                .toList();
    }

    public void printRaceResult(List<String> raceResult) {
        makeRaceResult(raceResult);

        for (StringBuilder res : result) {
            System.out.println(res.toString());
        }

        System.out.println();
    }

    private void makeRaceResult(List<String> raceResult) {
        for (int i = 0; i < result.size(); i++) {
            makeCarResult(raceResult.get(i), result.get(i));
        }
    }

    private void makeCarResult(String carAction, StringBuilder carResult) {
        if (carAction.equals("Move")) {
            carResult.append("-");
        }
    }
}

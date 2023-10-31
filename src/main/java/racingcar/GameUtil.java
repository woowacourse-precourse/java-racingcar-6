package racingcar;

public class GameUtil {

    private final CarUtil carUtil = new CarUtil();

    public void gameProceed(Game game) {
        for (Car car : game.getCars()) {
            carUtil.process(car);
        }
    }

    public String getWinnerCars(Game game) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : game.getCars()) {
            String name = carProgressCheck(car, game.goal);
            if(name.isEmpty()) {
               continue;
            }

            if (stringBuilder.isEmpty()) {
                stringBuilder.append(name);
            } else {
                stringBuilder.append(", ").append(name);
            }
        }

        return stringBuilder.toString();
    }

    public String carProgressCheck(Car car, int goal) {
        if (car.getProgress().length() >= goal) {
            return car.getRacingCar();
        } else {
            return "";
        }

    }

    public void show(String message) {
        System.out.println(message);
    }

    public void ProgressShow(Game game) {
        for (Car car : game.getCars()) {
            System.out.println(car.getRacingCar() + " : " + car.getProgress());
        }
    }

}

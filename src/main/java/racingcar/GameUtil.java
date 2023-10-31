package racingcar;

public class GameUtil {
    private final CarUtil carUtil = new CarUtil();

    public void gameProceed(Game game) {
        for(Car car : game.getCars()) {
            carUtil.process(car);
        }
    }

    public String getWinner(Game game) {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : game.getCars()) {
            if(stringBuilder.isEmpty()) {
                stringBuilder.append(getWinner(car, game.goal));
            } else {
                stringBuilder.append(", ").append(getWinner(car, game.goal));
            }
        }

        return stringBuilder.toString();
    }

    public String getWinner(Car car, int goal) {
        if(car.getProgress().length() >= goal) {
            return car.getRacingCar();
        }
        return "";
    }

    public void show(String message) {
        System.out.println(message);
    }

    public void ProgressShow(Game game) {
        for(Car car: game.getCars()) {
            System.out.println(car.getRacingCar() + " : " + car.getProgress());
        }
    }

}

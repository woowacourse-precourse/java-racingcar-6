package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class SimpleCar {
    private String carName;
    private String carMovement;

    private SimpleCar(String name) {
        this.carName = name;
        this.carMovement = "";
    }
    public static void createCar(List<String> playerNamesList, List<SimpleCar> players) {
        for(String playerName : playerNamesList) {
            SimpleCar car = new SimpleCar(playerName);
            players.add(car);
        }
    }
    public void goFoward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) this.carMovement += "-";
    }
    public String getCarName() {
        return carName;
    }
    public String getCarMovement() {
        return carMovement;
    }
}

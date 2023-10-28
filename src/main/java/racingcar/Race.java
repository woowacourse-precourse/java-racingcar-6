package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class Race {
    private ArrayList<Car> gameCar;

    public Race(String nameStr){
        gameCar = new ArrayList<>();
        String[] nameArr = nameStr.split(",");
        for(String name : nameArr)
            this.gameCar.add(new Car(name));
    }
    public void playGame(String timeStr) throws IllegalArgumentException{
        int time = Integer.parseInt(timeStr);
        for (int i = 0; i < time; i++) {
            moveCar();
            resultCar();
        }
    }
    public String checkWinner(){
        ArrayList<Integer> maxFindArr = new ArrayList<>();
        for (Car car : gameCar)
            maxFindArr.add(car.getMove());
        return maxFinder(maxFindArr);
    }

    private String maxFinder(ArrayList<Integer> maxFindArr){
        int max = Collections.max(maxFindArr);
        String reStr = "";

        for (int i = 0; i < maxFindArr.size(); i++)
            if (maxFindArr.get(i) == max)
                reStr += gameCar.get(i).getName() + ", ";

        if (reStr.length() > 0)
            reStr = reStr.substring(0,reStr.length() - 2);

        return reStr;
    }
    private void resultCar(){
        for (Car car : gameCar)
            System.out.println(car.getName() + " : " + "-".repeat(car.getMove()));
        System.out.println("");
    }
    private void moveCar(){
        for (Car car : gameCar)
            if (Randoms.pickNumberInRange(0,9) >= 4)
                car.plusMove();
    }

    public ArrayList<Car> getGameCar(){
        return gameCar;
    }
}

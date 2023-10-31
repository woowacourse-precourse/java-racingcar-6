package racingcar.racingGame;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void setDistance(String updateDist) {
        this.distance = updateDist;
    }

    public void tryMove() {

        int randNum = Randoms.pickNumberInRange(0, 9);

        if(randNum >= 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.distance);
            sb.append("-");
            setDistance(sb.toString());
        }
    }

}

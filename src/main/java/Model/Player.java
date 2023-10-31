package Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    String name;
    int distance;

    public Player(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void goForwardOrNot() {
        int runFlag = Randoms.pickNumberInRange(0, 9);
        if (runFlag >= 4) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        String res = name + " : ";
        for (int i = 0; i < distance; i++) {
            res += "-";
        }
        return res;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int position;

    RacingCar(String name, int position){
        this.name = name;
        this.position = position;
    }
    public static RacingCar createRacingCar(String name) {
        return new RacingCar(name, 0);
    }

    public void race() {
        if (isMoveFoward(createMove())) {
            this.position += 1;
        }
    }
    private int createMove() {
        return Randoms.pickNumberInRange(0,9);
    }
    private boolean isMoveFoward(int move) {
        if (move >= 4) {
            return true;
        }
        else {
            return false;
        }
    }
    public int getPosition() {
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}

package racingcar.domain;

public class RacingCar {


    private String name;
    private String moveCnt;

    public RacingCar(String name) {
        this.name = name;
        this.moveCnt = "";
    }

    public void addMoveCnt() {
        this.moveCnt += "-";
    }

    public String getRacingResult () {
        return name + " : " + moveCnt;
    }

    public int getMoveCntInt() {
        return moveCnt.length();
    }

    public String getName() {
        return name;
    }
}

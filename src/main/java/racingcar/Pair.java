package racingcar;

public class Pair<cn, cmt> {
    cn carname;
    cmt carmovetime;

    public Pair(cn carname, cmt carmovetime) {
        this.carname = carname;
        this.carmovetime = carmovetime;
    }

    public cn getKey() {
        return carname;
    }

    public cmt getValue() {
        return carmovetime;
    }
}

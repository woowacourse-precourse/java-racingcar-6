package racingcar.domain;

public class Participant implements Comparable<Participant> {
    private String name;

    private int forward;

    public Participant(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    @Override
    public int compareTo(Participant participant) {
        return this.forward - participant.getForward() ;
    }
}

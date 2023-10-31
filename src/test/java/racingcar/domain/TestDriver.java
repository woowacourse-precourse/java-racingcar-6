package racingcar.domain;

public class TestDriver implements Driver{
    private int number;

    public TestDriver(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}

package racingcar.dto;

public class RacingData {

    private String[] names;
    private int count = 0;

    public RacingData(String[] names, int count) {
        this.names = names;
        this.count = count;

        validate();
    }

    public String[] getNames() {
        return this.names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    private void validate() {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}

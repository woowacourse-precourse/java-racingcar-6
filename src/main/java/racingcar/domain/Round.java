package racingcar.domain;

public class Round {
    private int position;

    public Round() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }


    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }


    public String getRecord(String name) {
        StringBuilder record = new StringBuilder();
        record.append(String.format("%s : ", name));
        for (int i = 0; i < position; i++) {
            record.append('-');
        }
        return record.toString();
    }
}

package racingcar.model;

public class GameCount {
    private int count;

    GameCount(int count){
        this.count = count;
    }
    public void reduceCount(){
        count--;
    }

    public int getCount() {
        return count;
    }
}

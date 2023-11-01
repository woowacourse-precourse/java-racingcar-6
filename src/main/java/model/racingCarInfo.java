package model;

public class racingCarInfo{
        public final String name;
        public final int index;
        public int moveCount;
    public racingCarInfo(String name, int index){
            this.name=name;
            this.index=index;
            moveCount = 0;
        }
}
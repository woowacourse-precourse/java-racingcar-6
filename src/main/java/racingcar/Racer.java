package racingcar;

class Racer {
    public final String name;
    public final StringBuilder position;

    public Racer(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public void advance(){ //각 레이서 별의 position을 '-'로 변환
        position.append("-");
    }

    @Override
    public String toString(){ //racer별로 position출력
        return name + " : " + position.toString();
    }
}
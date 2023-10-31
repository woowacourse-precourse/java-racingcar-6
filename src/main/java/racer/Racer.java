package racer;

public class Racer {

    private RacerName name; // 경주자의 이름
    private int advance; // 경주자의 전진 거리
    private int duplicationCount; // 경주자의 중복 정도
    private String displayName; // 중복정도를 포함한 출력용 이름

    public Racer(String name, int duplicationCount) {
        this.name = new RacerName(name);
        this.advance = 0;
        this.duplicationCount = duplicationCount;
    }

    public String getName() {
        return name.getName();
    }

    public int getDuplicationCount() {
        return duplicationCount;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void increaseAdvance() {
        this.advance++;
    }

}

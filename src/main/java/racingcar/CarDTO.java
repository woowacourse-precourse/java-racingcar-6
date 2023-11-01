package racingcar;

public class CarDTO {
    private String name;
    private int forwardProgress;

    // 생성자
    public CarDTO(String name, int forwardProgress) {
        this.name = name;
        this.forwardProgress = forwardProgress;
    }

    // Getter 및 Setter 메서드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForwardProgress() {
        return forwardProgress;
    }

    public void setForwardProgress(int forwardProgress) {
        this.forwardProgress = forwardProgress;
    }

}

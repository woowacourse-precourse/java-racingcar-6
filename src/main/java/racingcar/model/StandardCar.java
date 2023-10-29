package racingcar.model;

import racingcar.util.GameUtil;

public class StandardCar implements Vehicle {
    private final String name;
    private int score = 0;

    public StandardCar(String name) {
        this.name = name;
    }

    public StandardCar(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public void addWinScore() {
        this.score++;
    }

    @Override
    public int getWinScore() {
        return this.score;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void tryMove(int movePoint) {
        int randomNumber = GameUtil.generateRandomNumber();
        if (randomNumber >= movePoint) {
            addWinScore();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle player = (Vehicle) obj;
        return name.equals(player.getName());
    }
}

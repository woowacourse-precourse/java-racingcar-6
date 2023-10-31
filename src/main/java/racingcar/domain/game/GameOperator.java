package racingcar.domain.game;


import racingcar.domain.car.Cars;

public interface GameOperator {
    Cars carGenerate();

    int setTrialCount();

    void print(String msg);
}

package racingcar.utils.generator;

import racingcar.car.MoveNumber;

public class RaceMoveNumberGenerator /*extends RandomNumberGenerator*/ {

//    @Override
//    public int generate() {
//        return super.generate();
//    }

    public static MoveNumber generate() {
        return new MoveNumber(new RandomNumberGenerator().generate());
    }
}

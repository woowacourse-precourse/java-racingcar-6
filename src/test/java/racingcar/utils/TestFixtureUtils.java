package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.CarCollection;
import racingcar.vo.CarInfo;
import racingcar.vo.RacingInfo;

import java.util.List;
import java.util.stream.IntStream;

public final class TestFixtureUtils {

    private TestFixtureUtils() {
    }

    public static RacingInfo generateRacingInfo(int carCnt, int repeatCnt) {
        return new RacingInfo(generateCarCollection(carCnt), repeatCnt);
    }

    public static CarCollection generateCarCollection(int carCnt) {
        return new CarCollection(TestFixtureUtils.generateCarList(carCnt));
    }

    private static List<CarInfo> generateCarList(int carCnt) {
        return IntStream.range(0, carCnt).mapToObj(i -> generateCar()).toList();
    }

    public static CarInfo generateCar(){
        return new CarInfo(generateRandomString(1,5));
    }

    public static String generateRandomString(int minLength, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(minLength, maxLength).forEach(i -> stringBuilder.append((char)(Randoms.pickNumberInRange(0,25)+'a')));
        return stringBuilder.toString();
    }

    public static Integer generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }


}

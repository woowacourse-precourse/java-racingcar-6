package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.WinnerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class WinnerServiceTest extends NsTest {
    WinnerService winnerService = new WinnerService();


    @Test//정렬 후 사용 필수!!
    public void 가장_큰_숫자_찾기(){
        //given
        Race testRace = new Race();
        testRace.setCars(Arrays.asList(new Car("lucy"),new Car("tom"),new Car("hemy"),new Car("hewo")));
        List<Integer> testNum1 = new ArrayList<>(Arrays.asList(8,7,6,5));
        IntStream.range(0, testRace.getCars().size()).forEach(idx -> {
            testRace.getCars().get(idx).setPoint(testNum1.get(idx));
        });
        //when & then
        Assertions.assertEquals(8, winnerService.getWinnerPoint(testRace));
    }

    @Test
    public void 가장_큰_숫자를_가진_CAR_객체들_찾기_CASE1(){
        //given
        Race testRace = new Race();
        testRace.setCars(Arrays.asList(new Car("lucy"),new Car("tom"),new Car("hemy"),new Car("hewo")));
        List<Integer> testNum1 = new ArrayList<>(Arrays.asList(7,6,5,4));
        IntStream.range(0, testRace.getCars().size()).forEach(idx -> {
            testRace.getCars().get(idx).setPoint(testNum1.get(idx));
        });
        List<Car> answer = Arrays.asList(testRace.getCars().get(0));

        //when & then
        Assertions.assertEquals(answer, winnerService.makeWinnersList(testRace, 7));
    }

    @Test
    public void 가장_큰_숫자를_가진_CAR_객체들_찾기_CASE2(){
        //given
        Race testRace = new Race();
        testRace.setCars(Arrays.asList(new Car("lucy"),new Car("tom"),new Car("hemy"),new Car("hewo")));
        List<Integer> testNum1 = new ArrayList<>(Arrays.asList(7,7,5,4));
        IntStream.range(0, testRace.getCars().size()).forEach(idx -> {
            testRace.getCars().get(idx).setPoint(testNum1.get(idx));
        });
        List<Car> answer = Arrays.asList(testRace.getCars().get(0),testRace.getCars().get(1));

        //when & then
        Assertions.assertEquals(answer, winnerService.makeWinnersList(testRace, 7));
    }

    @Test
    public void 가장_큰_숫자를_가진_CAR_객체들의_이름_리스트(){
        //given
        List<Car> test = Arrays.asList(new Car("lucy"),new Car("tom"));
        List<String> answer = Arrays.asList("lucy", "tom");

        //when & then
        IntStream.range(0, test.size()).forEach(idx -> {
            Assertions.assertEquals(answer.get(idx), winnerService.makeWinnerNameList(test).get(idx));
        });
    }

    @Test
    public void 우승자의_이름_프린트형식으로_합치기(){
        //given
        List<String> test = Arrays.asList("lucy", "tom");

        //when & then
        Assertions.assertEquals("lucy,tom", winnerService.makeWinnerNameForPrint(test));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

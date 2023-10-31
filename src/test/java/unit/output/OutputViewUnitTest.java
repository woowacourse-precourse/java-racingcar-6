package unit.output;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.input.CarInputDto;
import racingcar.dto.output.CarsOutputDto;
import racingcar.service.output.Output;
import racingcar.service.output.OutputView;

public class OutputViewUnitTest {

    private static final int TEST_CAR_NUMBER = 3;
    private static final int POSITION_EXCEPT_INDEX = 2;
    private Output output;

    @BeforeEach
    void init(){
        output = new OutputView();
    }

    @Test
    void 레이스_한_턴_결과값_출력(){
        //given
        String[] testCars = {"car1","car2","car3"};
        Cars cars = Cars.of(new CarInputDto(testCars));
        updatePositionWithOutNumberTwo(cars);
        CarsOutputDto carsOutputDto = new CarsOutputDto(cars);

        // sout 검증 클래스
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        output.showPlaying(carsOutputDto);

        // 다시 설정 복원
        System.setOut(originalOut);
        //then - 검증
        String capturedOutput = baos.toString().trim();
        String outputExpected= "car1 : -\ncar2 : -\ncar3 :";
        assertThat(outputExpected).isEqualTo(capturedOutput);
    }
    


    @Test
    void 레이스_총_결과_출력(){
        //given
        String[] testCars = {"car1","car2","car3"};
        Cars cars = Cars.of(new CarInputDto(testCars));
        updatePositionWithOutNumberTwo(cars);
        CarsOutputDto carsOutputDto = new CarsOutputDto(cars);

        // sout 검증 클래스
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 임시로 리디렉션하여 캡쳐
        System.setOut(new PrintStream(baos));

        //when
        output.showResult(carsOutputDto);
        // 다시 설정 복원
        System.setOut(originalOut);

        //then - 검증
        String capturedOutput = baos.toString().trim();
        String outputExpected= "최종 우승자 : car1, car2";
        assertThat(outputExpected).isEqualTo(capturedOutput);
    }

    private static void updatePositionWithOutNumberTwo(Cars cars) {
        for (int i = 0; i < TEST_CAR_NUMBER; i++){
            if (isTwo(i)) {
                continue;
            }
            updatePosition(cars, i);

        }
    }
    private static void updatePosition(Cars cars, int i) {
        Car car = cars.getCarList().get(i);
        car.updatePosition();
    }

    private static boolean isTwo(int i) {
        if(i == POSITION_EXCEPT_INDEX){
            return true;
        }
        return false;
    }
}

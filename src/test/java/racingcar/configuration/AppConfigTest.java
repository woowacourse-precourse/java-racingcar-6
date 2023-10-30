package racingcar.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingRepository;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigTest {

    Config config = AppConfig.getInstance();

    @Test
    public void AppConfig가_싱글톤인지() {
        // given && when
        Config config1 = AppConfig.getInstance();
        Config config2 = AppConfig.getInstance();

        // then
        assertThat(config1).isInstanceOf(Config.class);
        assertThat(config1).isNotNull();
        assertThat(config2).isNotNull();
        assertThat(config1).isSameAs(config2);
    }

    @Test
    public void CarRepository가_싱글톤인지() {
        // given && when
        CarRepository carRepository1 = config.carRepository();
        CarRepository carRepository2 = config.carRepository();

        // then
        assertThat(carRepository1).isInstanceOf(CarRepository.class);
        assertThat(carRepository1).isNotNull();
        assertThat(carRepository2).isNotNull();
        assertThat(carRepository1).isSameAs(carRepository2);
    }

    @Test
    public void RacingRepository가_싱글톤인지() {
        // given && when
        RacingRepository racingRepository1 = config.racingRepository();
        RacingRepository racingRepository2 = config.racingRepository();

        // then
        assertThat(racingRepository1).isInstanceOf(RacingRepository.class);
        assertThat(racingRepository1).isNotNull();
        assertThat(racingRepository2).isNotNull();
        assertThat(racingRepository1).isSameAs(racingRepository2);
    }

    @Test
    public void CarService가_싱글톤인지() {
        // given && when
        CarService carService1 = config.carService();
        CarService carService2 = config.carService();

        // then
        assertThat(carService1).isInstanceOf(CarService.class);
        assertThat(carService1).isNotNull();
        assertThat(carService2).isNotNull();
        assertThat(carService1).isSameAs(carService2);
    }

    @Test
    public void RacingService가_싱글톤인지() {
        // given && when
        RacingService racingService1 = config.racingService();
        RacingService racingService2 = config.racingService();

        // then
        assertThat(racingService1).isInstanceOf(RacingService.class);
        assertThat(racingService1).isNotNull();
        assertThat(racingService2).isNotNull();
        assertThat(racingService1).isSameAs(racingService2);
    }

    @Test
    public void InputView가_싱글톤인지() {
        // given && when
        InputView inputView1 = config.inputView();
        InputView inputView2 = config.inputView();

        // then
        assertThat(inputView1).isInstanceOf(InputView.class);
        assertThat(inputView1).isNotNull();
        assertThat(inputView2).isNotNull();
        assertThat(inputView1).isSameAs(inputView2);
    }

    @Test
    public void OutputView가_싱글톤인지() {
        // given && when
        OutputView outputView1 = config.outputView();
        OutputView outputView2 = config.outputView();

        // then
        assertThat(outputView1).isInstanceOf(OutputView.class);
        assertThat(outputView1).isNotNull();
        assertThat(outputView2).isNotNull();
        assertThat(outputView1).isSameAs(outputView2);
    }

    @Test
    public void RacingController가_싱글톤인지() {
        // given && when
        RacingController racingController1 = config.racingController();
        RacingController racingController2 = config.racingController();

        // then
        assertThat(racingController1).isInstanceOf(RacingController.class);
        assertThat(racingController1).isNotNull();
        assertThat(racingController2).isNotNull();
        assertThat(racingController1).isSameAs(racingController2);
    }
}
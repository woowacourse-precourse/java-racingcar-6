package racingcar.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.service.RacingGameService;
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
        RacingGameRepository racingGameRepository1 = config.racingRepository();
        RacingGameRepository racingGameRepository2 = config.racingRepository();

        // then
        assertThat(racingGameRepository1).isInstanceOf(RacingGameRepository.class);
        assertThat(racingGameRepository1).isNotNull();
        assertThat(racingGameRepository2).isNotNull();
        assertThat(racingGameRepository1).isSameAs(racingGameRepository2);
    }

    @Test
    public void RacingService가_싱글톤인지() {
        // given && when
        RacingGameService racingGameService1 = config.racingService();
        RacingGameService racingGameService2 = config.racingService();

        // then
        assertThat(racingGameService1).isInstanceOf(RacingGameService.class);
        assertThat(racingGameService1).isNotNull();
        assertThat(racingGameService2).isNotNull();
        assertThat(racingGameService1).isSameAs(racingGameService2);
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
        RacingGameController racingGameController1 = config.racingController();
        RacingGameController racingGameController2 = config.racingController();

        // then
        assertThat(racingGameController1).isInstanceOf(RacingGameController.class);
        assertThat(racingGameController1).isNotNull();
        assertThat(racingGameController2).isNotNull();
        assertThat(racingGameController1).isSameAs(racingGameController2);
    }
}
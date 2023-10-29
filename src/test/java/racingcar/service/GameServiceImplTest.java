package racingcar.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

public class GameServiceImplTest {

    private CarRepository memoryCarRepository = MemoryCarRepository.getInstance();
    private CarService carService = CarServiceImpl.getInstance(memoryCarRepository);
    GameService gameService = GameServiceImpl.getInstance(carService);

    @BeforeEach
    public void setUp() {
        memoryCarRepository.deleteAll();
    }

    @Test
    public void Car들_한줄에_입력받아_저장하기() {
        // given
        String input = "pobi,woni,jun";

        // when
        gameService.processCarNamesInput(input);

        // then
        assertThat(memoryCarRepository.findAll()).hasSize(3); // 저장된 자동차가 3개여야 함
    }
}

package racingcar.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.console.Console;

class ConsoleFactoryTest {

    @Test
    void Console_클래스_싱글톤_생성_테스트() {
        // given
        Console singletonConsole1 = ConsoleFactory.createSingletonConsole();
        Console singletonConsole2 = ConsoleFactory.createSingletonConsole();
        Console singletonConsole3 = ConsoleFactory.createSingletonConsole();
        Console singletonConsole4 = ConsoleFactory.createSingletonConsole();

        // when
        // then
        Assertions.assertThat(singletonConsole1)
                .isSameAs(singletonConsole2)
                .isSameAs(singletonConsole3)
                .isSameAs(singletonConsole4)
        ;
    }
    
}
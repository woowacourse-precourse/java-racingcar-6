package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.TestConsts.TEMP_CLIENT_ROUND;

class ClientTest {

    @Test
    void getTotalRounds() {
        Client client = new Client(TEMP_CLIENT_ROUND);
        assertThat(client).isExactlyInstanceOf(Client.class);
        assertThat(client.getTotalRounds()).isEqualTo(3);
    }
}
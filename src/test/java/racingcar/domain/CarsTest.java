package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.stubs.AlwaysGoStrategy;
import racingcar.domain.stubs.NeverGoStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 컬렉션을_한_라운드_일괄_이동시킨다() {
        Car pobi = new Car(new Name("pobi"));
        Car woni = new Car(new Name("woni"));
        Car jun  = new Car(new Name("jun"));

        Cars cars = new Cars(Arrays.asList(pobi, woni, jun));
        cars.raceOnce(new AlwaysGoStrategy());

        assertEquals(1, pobi.position());
        assertEquals(1, woni.position());
        assertEquals(1, jun.position());
    }

    @Test
    void 우승자는_최대_위치이며_복수_가능하다() {
        Car pobi = new Car(new Name("pobi"));
        Car woni = new Car(new Name("woni"));
        Car jun = new Car(new Name("jun"));

        Cars cars = new Cars(Arrays.asList(pobi, woni, jun));

        cars.raceOnce(new AlwaysGoStrategy());
        cars.raceOnce(new AlwaysGoStrategy());

        woni.move(new NeverGoStrategy());
        pobi.move(new AlwaysGoStrategy());

        jun.move(new AlwaysGoStrategy());

        List<String> winners = cars.winners();
        assertEquals(2, winners.size());
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("jun"));
    }

    @Test
    void 빈_컬렉션은_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(List.of()));
    }
}
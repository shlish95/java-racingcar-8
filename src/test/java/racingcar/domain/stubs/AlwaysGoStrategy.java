package racingcar.domain.stubs;

import racingcar.domain.MoveStrategy;

public class AlwaysGoStrategy implements MoveStrategy {

    @Override
    public boolean movable() {
        return true;
    }
}

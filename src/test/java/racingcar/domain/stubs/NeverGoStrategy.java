package racingcar.domain.stubs;

import racingcar.domain.MoveStrategy;

public class NeverGoStrategy implements MoveStrategy {

    @Override
    public boolean movable() {
        return false;
    }
}

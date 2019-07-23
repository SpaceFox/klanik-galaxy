package klanik.technicaltests.galaxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimulatorTest {

    private final Galaxy simpleGalaxy = new Galaxy(
            Star.builder()
                    .mass(1).radius(0.1)
                    .position(new Position(1, 0, 0))
                    .speed(new Speed(0, 0, 0))
                    .build(),
            Star.builder()
                    .mass(1).radius(0.1)
                    .position(new Position(-1, 0, 0))
                    .speed(new Speed(0, 0, 0))
                    .build()
    );

    @Test void generalBehaviour() {
        Simulator simulator = new Simulator(simpleGalaxy);
        simulator.nextStep();

        final Galaxy futureGalaxy = simulator.getFutureGalaxy();
        assertNotNull(futureGalaxy);
    }

    @Test void nextStepFutureBecomesCurrent() {
        Simulator simulator = new Simulator(new Galaxy());
        simulator.setFutureGalaxy(simpleGalaxy);
        simulator.nextStep();
        assertEquals(simpleGalaxy, simulator.getCurrentGalaxy());
    }
}

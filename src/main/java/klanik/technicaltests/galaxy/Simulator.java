package klanik.technicaltests.galaxy;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

/**
 * The galaxy simulator
 */
@Getter
@Setter
public class Simulator {

    private @NotNull Galaxy currentGalaxy;
    private Galaxy futureGalaxy;

    public Simulator(@NotNull Galaxy currentGalaxy) {
        this.currentGalaxy = currentGalaxy;
    }

    public void nextStep() {
        if (futureGalaxy != null) {
            currentGalaxy = futureGalaxy;
        }
        futureGalaxy = currentGalaxy.stream()
                .map(star -> applyInfluenceOn(star, currentGalaxy))
                .collect(Collectors.toCollection(Galaxy::new));
    }

    private Star applyInfluenceOn(Star currentStar, Galaxy currentGalaxy) {
        currentGalaxy.forEach(distantStar -> applyInfluenceOn(currentStar, distantStar));
        return currentStar;
    }

    private Star applyInfluenceOn(Star currentStar, Star distantStar) {
        if (currentStar.equals(distantStar)) {
            return currentStar;
        }
        currentStar.move();
        double distance = currentStar.computeDistance(distantStar.getPosition());
        if (distance <= (currentStar.getRadius() + distantStar.getRadius())) {
            // TODO stars with distance less than their radius should merge
        } else {
            currentStar.influenceWith(distantStar);
        }
        return currentStar;
    }
}

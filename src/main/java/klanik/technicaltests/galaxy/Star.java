package klanik.technicaltests.galaxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Star {

    private @NotNull Position position;
    private @NotNull Speed speed;
    private double mass;
    private double radius;

    /**
     * Move star from old position to new one applying current speed vector
     */
    public void move() {
        position.setX(position.getX() + speed.getX());
        position.setY(position.getY() + speed.getY());
        position.setZ(position.getZ() + speed.getZ());
    }

    /**
     * Influence star speed from distant star
     * @param distantStar the distant star that influences (= modify speed vector of) current star
     */
    public void influenceWith(Star distantStar) {
        // TODO update speed vector with distant star influence
    }

    public double computeDistance(@NotNull Position distantPosition) {
        return Math.sqrt(
                (position.getX() - distantPosition.getX()) * (position.getX() - distantPosition.getX())
                + (position.getY() - distantPosition.getY()) * (position.getY() - distantPosition.getY())
                + (position.getZ() - distantPosition.getZ()) * (position.getZ() - distantPosition.getZ()));
    }
}

package klanik.technicaltests.galaxy;

import java.util.HashSet;
import java.util.Set;

public class Galaxy extends HashSet<Star> {

    public Galaxy() {
    }

    public Galaxy(Star... stars) {
        super(Set.of(stars));
    }
}

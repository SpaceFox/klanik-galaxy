package klanik.technicaltests.galaxy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * A simple 3D vector
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
abstract class Vector3D {

    private double x;
    private double y;
    private double z;
}

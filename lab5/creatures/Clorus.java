package creatures;

import huglife.*;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.*;

/**
 * An implementation of a fierce blue-colored predator of Plips.
 *
 * @author Bchung
 */

public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * Should return a color with red = 34, green = 0, and blue = 231.
     */
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    /**
     * Cloruses gain energy of the creature they attack.
     */
    public void attack(Creature c) {
        energy = c.energy();
    }

    /**
     * Cloruses lose 0.03 units of energy when they move.
     */
    public void move() {
        energy -= 0.03;
    }

    /**
     * Cloruses lose 0.01 units of energy when they stay.
     */
    public void stay() {
        energy -= 0.01;
    }

    /**
     * Cloruses and their offspring each get 50% of the energy, with none
     * lost to the process.Returns a baby Clorus.
     */
    public Clorus replicate() {
        energy = energy / 2;
        return new Clorus(energy);
    }

    /**
     * Cloruses take the following actions in the exact order based on their NEIGHBORS.
     * 1. If there are no empty spaces, the Clorus will STAY.
     * 2. If any Plips are seen, the Clorus will ATTACK one of them randomly.
     * 3. If the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty space.
     * 4. The Clorus will MOVE to a random empty space.
     **/
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();

        for (Direction direction: neighbors.keySet()) {
            if (neighbors.get(direction).name() == "empty") {
                emptyNeighbors.add(direction);
            } else if (neighbors.get(direction).name() == "plip") {
                plipNeighbors.add(direction);
            }
        }

        if (emptyNeighbors.isEmpty()) {
            return new Action(Action.ActionType.STAY);
        }

        // Rule 2
        if (!plipNeighbors.isEmpty()) {
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        }

        // Rule 3
        if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }

        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
    }
}

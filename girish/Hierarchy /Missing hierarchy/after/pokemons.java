package Missing_Hierarchy.Pokemons;

import Missing_Hierarchy.Entity;
import Missing_Hierarchy.Move;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pokemon extends Entity {
    private int health;
    private int speed;
    private ArrayList<Move> moveSet;

    public Pokemon(String name, int health, int speed) {
        super(name, "");
        this.health = health;
        this.speed = speed;
        this.moveSet = new ArrayList<>();
    }

    public abstract void attack(Entity target, Move move);

    protected void applyDamage(Entity target, Move move, int damageMultiplier) {
        int damage = move.getDamage() * damageMultiplier;
        target.setHealth(target.getHealth() - damage);
    }

    protected Move getRandomMove() {
        Random random = new Random();
        int randomIndex = random.nextInt(moveSet.size());
        return moveSet.get(randomIndex);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Move> getMoveSet() {
        return moveSet;
    }

    public void setMoveSet(ArrayList<Move> moveSet) {
        this.moveSet = moveSet;
    }
}

package Missing_Hierarchy.Pokemons;

import Missing_Hierarchy.Move;
import Missing_Hierarchy.Types.Fire;
import Missing_Hierarchy.Types.Water;

public class Charmander extends Pokemon {
    private static final int BASE_HEALTH = 39;
    private static final int BASE_SPEED = 65;

    public Charmander(String name) {
        super(name, BASE_HEALTH, BASE_SPEED);
        this.setMoveSet(makeMoveSet());
    }

    @Override
    public void attack(Entity target, Move move) {
        if (target instanceof Pokemon) {
            Pokemon targetPokemon = (Pokemon) target;
            if (targetPokemon.getType() instanceof Water) {
                int damageMultiplier = 2;
                if (getType().getWeakness().contains(move.getTypeName())) {
                    damageMultiplier = 3;
                    System.out.println(getName() + " used " + move.getName() + " - it's super effective!");
                } else if (getType().getEffectives().contains(move.getTypeName())) {
                    damageMultiplier = 1;
                    System.out.println(getName() + " used " + move.getName() + " - it's not very effective.");
                }
                applyDamage(targetPokemon, move, damageMultiplier);
            }
        }
    }

    private static ArrayList<Move> makeMoveSet() {
        ArrayList<Move> learnableMoves = learnableMoves();
        ArrayList<Move> newMoveSet = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(learnableMoves.size());
            Move move = learnableMoves.get(randomIndex);
            newMoveSet.add(move);
        }

        return newMoveSet;
    }

    private static ArrayList<Move> learnableMoves() {
        ArrayList<Move> learnableMoves = new ArrayList<>();
        learnableMoves.add(new Move("Ember", 40, 100, "fire"));
        return learnableMoves;
    }
}

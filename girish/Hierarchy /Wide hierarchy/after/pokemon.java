package Wide_Hierarchy.Pokemons;

import Wide_Hierarchy.Move;
import Wide_Hierarchy.Types.Fire;

import java.util.ArrayList;
import java.util.Random;

public class Charmander extends IntermediatePokemon {
    public Charmander(String name) {
        super(name, Sprite(), 39, new Fire());
        setMoveSet(makeMoveSet());
    }

    private static String Sprite(){
        String charmanderSprite = "";
        return charmanderSprite;
    }

    private ArrayList<Move> makeMoveSet(){
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

    private static ArrayList<Move> learnableMoves(){
        ArrayList<Move> learnableMoves = new ArrayList<>();
        learnableMoves.add(new Move("Ember", 40, 100, "fire"));
        return learnableMoves;
    }
}

package Wide_Hierarchy.Pokemons;

import Wide_Hierarchy.Entity;
import Wide_Hierarchy.Move;
import Wide_Hierarchy.Types.Type;

public abstract class IntermediatePokemon extends Pokemon {
    private String sprite;

    public IntermediatePokemon(String name, String sprite, int health, Type type) {
        super(name, health, type);
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}

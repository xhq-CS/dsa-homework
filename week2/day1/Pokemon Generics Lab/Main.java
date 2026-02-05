import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Pokemon
        Pokemon pikachu = new Pokemon("Pikachu", "Electric");
        Pokemon charmander = new Pokemon("Charmander", "Fire");
        PokeBox box = new PokeBox(pikachu);
        System.out.println(box.get());
        box.set(charmander);
        System.out.println(box.get() + "\n");

        //Box and Held Item
        Box<Pokemon> pokemonBox = new Box<>(pikachu);
        Box<String> itemBox = new Box<>("Oran Berry");
        Box<Integer> levelBox = new Box<>(25);
        Pair<Pokemon, String> heldItem = new Pair<>(pikachu, "Oran Berry");
        System.out.println(heldItem + "\n");

        //Pokemon Type
        PokemonOnlyBox<Pokemon> b1 = new PokemonOnlyBox<>(pikachu);
        System.out.println("Type: " + b1.getType() + "\n");

        //Pokemon Battle HP
        BattlePokemon squirtle = new BattlePokemon("Squirtle", "Water", 60);
        PokemonOnlyBox<BattlePokemon> battleBox = new PokemonOnlyBox<>(squirtle);
        System.out.println(battleBox.get() + "\n");

        //Item Swap
        Box<String> a = new Box<>("Potion");
        Box<String> b = new Box<>("Rare Candy");
        System.out.println("Before: a=" + a.get() + ", b=" + b.get());
        swap(a, b);
        System.out.println("After:  a=" + a.get() + ", b=" + b.get() + "\n");

        //Pokemon Team Printer
        List<Pokemon> team = new ArrayList<>();
        team.add(pikachu);
        team.add(charmander);
        printTeam(team);
        //Battle Pokemon Team Printer
        List<BattlePokemon> battle = new ArrayList<>();
        battle.add(new BattlePokemon("Samurott", "Water", 95));
        battle.add(new BattlePokemon("Typhlosion", "Fire", 78));
        printTeam(battle);
    }

    public static <T> void swap(Box<T> a, Box<T> b) {
        T temp = a.get();
        b.set(temp);
    }

    public static void printTeam(java.util.List<? extends Pokemon> Team) {
        for (Pokemon poke : Team) {
            System.out.println(poke);
        }
        System.out.println();
    }
}

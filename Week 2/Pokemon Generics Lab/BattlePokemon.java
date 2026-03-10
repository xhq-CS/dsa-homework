public class BattlePokemon<T extends Pokemon> extends Pokemon {
    private int hp;

    public BattlePokemon(String name, String type, int hp) {
        super(name, type);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + hp + " HP ";
    }
}

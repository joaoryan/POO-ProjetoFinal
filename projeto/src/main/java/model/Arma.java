package model;

public class Arma {
    private String type;
    private String name;
    private int level;
    private int damage;
    private int Presonagem_id;

    public Arma(String type, String name, int level, int damage, int presonagem_id) {
        this.type = type;
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.Presonagem_id = presonagem_id;
    }


}

package model;

public abstract class Personagem {

    public String name;
    public String level;
    public String classCharacter;
    public String race;

    public Personagem(String name, String level, String classCharacter, String race) {
        this.name = name;
        this.level = level;
        this.classCharacter = classCharacter;
        this.race = race;
    }
}

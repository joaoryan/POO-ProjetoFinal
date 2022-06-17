package model;

import model.Personagem;
import model.interfaceCode.Espada;

public class Cavaleiro extends Personagem implements Espada {
    public Cavaleiro(String name, String level, String classCharacter, String race) {
        super(name, level, classCharacter, race);
    }

    @Override
    public void girar(int dano) {
        System.out.println("Personagem gira sua espada gerando um dano de " + dano);
    }

    @Override
    public void corteSangramento(int dano) {
        System.out.println("Personagem faz um golpe suave mais letal gerando um dano de " + dano);
    }
}

package model;

import model.Personagem;
import model.interfaceCode.Cura;
import model.interfaceCode.Magia;

public class Mago extends Personagem implements Cura, Magia {
    public Mago(String name, String level, String classCharacter, String race) {
        super(name, level, classCharacter, race);
    }

    @Override
    public void curar() {
        System.out.println("Personagem utiliza sua cura");
    }

    @Override
    public void usaFeitico(int dano) {
        System.out.println("Um feitiso muito poderoso e lançado gerando um dano de " + dano);
    }

    @Override
    public void usaFogo(int dano) {
        System.out.println("Uma bola de fogo e lançada gerando um dano de " + dano);
    }
}

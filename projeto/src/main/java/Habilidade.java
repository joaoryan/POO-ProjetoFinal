public class Habilidade implements Cura, Espada, Magia{

    private String nome;
    private  int level;
    private  String type;
    private String info;

    public Habilidade(String nome, int level, String type, String info) {
        this.nome = nome;
        this.level = level;
        this.type = type;
        this.info = info;
    }

    @Override
    public void curar() {

    }

    @Override
    public void girar(int dano) {

    }

    @Override
    public void corteSangramento(int dano) {

    }

    @Override
    public void usaFeitico(int dano) {

    }

    @Override
    public void usaFogo(int dano) {

    }
}

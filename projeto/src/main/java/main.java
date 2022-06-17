import controller.personagemDAO;
import model.Cavaleiro;
import model.Mago;
import model.Samurai;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        personagemDAO iDAO = new personagemDAO();
        boolean repetir = true;

        do{
            System.out.print("##-- Menu --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opcao 1 - Novo Cadastro     |\n");
            System.out.print("| Opcao 2 - Deletar pelo id   |\n");
            System.out.print("| Opcao 3 - Buscar pelo id    |\n");
            System.out.print("| Opcao 4 - Atualizar         |\n");
            System.out.print("| Opcao 5 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opcao: ");

            int opcao = teclado.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Escolha a classe do personagem: ");
                    System.out.print("| Opcao 1 - Mago      |\n");
                    System.out.print("| Opcao 2 - Samurai   |\n");
                    System.out.print("| Opcao 3 - Cavaleiro |\n");
                    System.out.print("Digite uma opcao de sua classe: ");
                    int classeOpcao = teclado.nextInt();
                    String classCharacter = null;

                    switch (classeOpcao) {
                        case 1:
                            classCharacter = "Mago";
                            break;

                        case 2:
                            classCharacter = "Samurai";
                            break;

                        case 3:
                            classCharacter = "Cavaleiro";
                            break;

                        default:
                            System.out.print("\nOpção Inválida!");
                            break;
                    }
                    String confirm= teclado.nextLine();

                    System.out.println("Agora que vc escolheu sua classe diga seu nome e sua raca:");
                    System.out.print("Digite seu nome:");
                    String name = teclado.nextLine();
                    System.out.print("Digite sua raca:");
                    String race = teclado.nextLine();

                    System.out.print("Me diga o tipo de arma voce utiliza:");
                    String tipo = teclado.nextLine();
                    System.out.print("qual o nome de sua arma:");
                    String nomeArma = teclado.nextLine();

                    System.out.print("Diga o tipo de sua montaria:");
                    String tipoMontaria = teclado.nextLine();
                    System.out.print("Descreva o nome de sua montaria: ");
                    String nomeMontaria = teclado.nextLine();

                    if(classCharacter == "Cavaleiro"){
                        Cavaleiro cavaleiro1 = new Cavaleiro(name,"1","cavaleiro", race);
                        iDAO.insertCharacter(cavaleiro1);
                    }
                    else if(classCharacter == "Mago"){
                        Mago mago1 = new Mago(name,"1","mago", race);
                        iDAO.insertCharacter(mago1);
                    }
                    else if (classCharacter == "Samurai"){
                        Samurai samurai1 = new Samurai(name,"1","samurai", race);
                        iDAO.insertCharacter(samurai1);
                    }
                    else {
                        System.out.println("Essa classe não existe nesté mundo");
                    }

                    break;

                case 2:

                    System.out.println("Digite o id que deseja deletar: ");
                    int idDelete = teclado.nextInt();
                    iDAO.deletarCharacter(idDelete);
                    break;

                case 3:

                    System.out.println("Digite o id que deseja buscar: ");
                    int idBuscar = teclado.nextInt();
                    iDAO.buscarCharacterId(idBuscar);
                    break;

                case 4:

                    System.out.println("Digite o id que deseja editar: ");
                    int idEdit = teclado.nextInt();

                    System.out.println("Escolha a classe do personagem que deseja editar: ");
                    System.out.print("| Opcao 1 - Mago      |\n");
                    System.out.print("| Opcao 2 - Samurai   |\n");
                    System.out.print("| Opcao 3 - Cavaleiro |\n");
                    System.out.print("Digite uma opcao de sua classe: ");
                    int classeOpcaoEdit = teclado.nextInt();
                    String classCharacterEdit = null;
                    switch (classeOpcaoEdit) {
                        case 1:
                            classCharacterEdit = "Mago";
                            break;

                        case 2:
                            classCharacterEdit = "Samurai";
                            break;

                        case 3:
                            classCharacterEdit = "Cavaleiro";
                            break;

                        default:
                            System.out.print("\nOpção Inválida!");
                            break;
                    }
                    String confirmEdit= teclado.nextLine();
                    System.out.print("nome que deseja editar: ");
                    String nameEdit = teclado.nextLine();

                    System.out.println("raca que deseja editar: ");
                    String raceEdit = teclado.nextLine();

                    if(classCharacterEdit == "Cavaleiro"){
                        Cavaleiro cavaleiroEdit = new Cavaleiro(nameEdit,"1","cavaleiro", raceEdit);
                        iDAO.atualizarCharacter(idEdit, cavaleiroEdit);
                    }
                    else if(classCharacterEdit == "Mago"){
                        Mago magoEdit = new Mago(nameEdit,"1","mago", raceEdit);
                        iDAO.atualizarCharacter(idEdit, magoEdit);
                    }
                    else if (classCharacterEdit == "Samurai"){
                        Samurai samuraiEdit = new Samurai(nameEdit,"1","samurai", raceEdit);
                        iDAO.atualizarCharacter(idEdit, samuraiEdit);
                    }
                    else {
                        System.out.println("Essa classe não existe nesté mundo");
                    }
                    break;

                case 5:
                  repetir = false;
                    break;

                default:
                    System.out.print("\nOpcao Inválida!");
                    break;
            }
        } while (repetir);
    }
}

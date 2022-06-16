import dao.instrumentoDAO;
import model.Samurai;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        instrumentoDAO iDAO = new instrumentoDAO();

        System.out.print("##--Teste Estrutura de Menu--##\n\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("| Opcao 1 - Novo Cadastro     |\n");
        System.out.print("| Opcao 2 - Deletar cadastro  |\n");
        System.out.print("| Opcao 3 - Buscar            |\n");
        System.out.print("| Opcao 4 - Atualizar         |\n");
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

                System.out.print("nome: ");
                String name = teclado.nextLine();

                System.out.println("raca: ");
                String race = teclado.nextLine();

                System.out.print("Me diga o tipo de arma você utiliza:");
                String tipo = teclado.nextLine();
                System.out.println("qual o nome de sua arma:");
                String nomeArma = teclado.nextLine();

                System.out.print("Diga o tipo de sua montaria:");
                String tipoMontaria = teclado.nextLine();
                System.out.println("Descreva o nome de sua montaria: ");
                String nomeMontaria = teclado.nextLine();

                if(classCharacter == "Cavaleiro"){
                    Cavaleiro cavaleiro1 = new Cavaleiro(name,"1","cavaleiro", race);
                    iDAO.insertCharacter(cavaleiro1);
                }
                else if(classCharacter == "Mago"){
                    Mago mago1 = new Mago(name,"1","mago", race);
                    iDAO.insertCharacter(mago1);
                }
                else if (classCharacter == "model.Samurai"){
                    Samurai samurai1 = new Samurai(name,"1","samurai", race);
                    iDAO.insertCharacter(samurai1);
                }
                else {
                    System.out.println("Essa classe não existe nesté mundo");
                }
                break;

            case 2:
                iDAO.deletarInstrumento(1);
                break;

            case 3:
                iDAO.buscarInstrumentoPorId(3);
                break;

            case 4:
                System.out.println("Digite o id que deseja editar: ");
                int idEdit = teclado.nextInt();

                System.out.println("Escolha a classe do personagem: ");
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

                System.out.print("nome que deseja editar: ");
                String nameEdit = teclado.nextLine();

                System.out.println("raca que deseja editar: ");
                String raceEdit = teclado.nextLine();

                if(classCharacterEdit == "Cavaleiro"){
                    Cavaleiro cavaleiroEdit = new Cavaleiro(nameEdit,"1","cavaleiro", raceEdit);
                    iDAO.atualizarInstrumento(idEdit, cavaleiroEdit);
                }
                else if(classCharacterEdit == "Mago"){
                    Mago magoEdit = new Mago(nameEdit,"1","mago", raceEdit);
                    iDAO.atualizarInstrumento(idEdit, magoEdit);
                }
                else if (classCharacterEdit == "model.Samurai"){
                    Samurai samuraiEdit = new Samurai(nameEdit,"1","samurai", raceEdit);
                    iDAO.atualizarInstrumento(idEdit, samuraiEdit);
                }
                else {
                    System.out.println("Essa classe não existe nesté mundo");
                }
                break;


            default:
                System.out.print("\nOpcao Inválida!");
                break;
        }
    }
}

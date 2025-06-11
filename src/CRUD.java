import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) {
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 10;

        while(opcao != 0){
            try {
                System.out.println("**************************************");
                System.out.println("SEJA VEM VINDO AO SISTEMA DE VEÍCULOS");
                System.out.println("**************************************");

                System.out.println("1 - Cadastrar veículo");
                System.out.println("2 - Listar veículos cadastrados");
                System.out.println("3 - Atualizar os dados do veículo");
                System.out.println("4 - Remover veículo");
                System.out.println("5 - Realizar manutenção em um veículo");
                System.out.println("0 - Sair");
                System.out.print("Insira a opção desejada: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if(opcao == 1) {
                    System.out.println("**************************************");
                    System.out.println("SEJA VEM VINDO AO CADASTRO DE VEÍCULOS");
                    System.out.println("**************************************");

                    System.out.println("1 - Cadastrar Moto");
                    System.out.println("2 - Cadastrar Carro");
                    System.out.print("Insira a opção: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println();
                    System.out.print("Insira a placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Insira a marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Insira o modelo: ");
                    String modelo = scanner.nextLine();

                    Veiculo veiculo;
                    if (tipo == 1) {
                        System.out.printf("Moto %s cadastrada com sucesso!\n", placa);
                        veiculo = new Moto(placa, marca, modelo);
                    } else {
                        System.out.printf("Carro %s cadastrado com sucesso!", placa);
                        veiculo = new Carro(placa, marca, modelo);
                    }

                    listaVeiculos.add(veiculo);
                }

            }catch (InputMismatchException error){
                System.out.println("A opção deve ser somente números!");
                break;
            } if(opcao == 2){
                System.out.println("Listagem de veículos!");

                if(listaVeiculos.isEmpty()) {
                    for (Veiculo veiculo : listaVeiculos) {
                        veiculo.exibirDados();
                        System.out.println("--------------------");
                    }
                }
            }else if(opcao == 3){
                System.out.println("Insira a placa do veículo que deseja atualizar: ");
                String placaBusca = scanner.nextLine();
            }

        }

    }

}

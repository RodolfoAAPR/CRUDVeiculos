import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

        public static void main(String[] args) {
            ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            ManipulacaoDados.carregarDados(listaVeiculos);
            int opcao = 10;


            while(opcao != 0) {
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

                    if (opcao == 1) {
                        System.out.println();
                        System.out.println("**************************************");
                        System.out.println("SEJA VEM VINDO AO CADASTRO DE VEÍCULOS");
                        System.out.println("**************************************");

                        System.out.println("1 - Cadastrar Moto");
                        System.out.println("2 - Cadastrar Carro");
                        System.out.print("Insira a opção: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        Veiculo veiculo;
                        if (tipo == 1) {
                            System.out.println();
                            System.out.print("Insira a placa: ");
                            String placa = scanner.nextLine();

                            if (Busca.buscarPorPlaca(listaVeiculos, placa) != null) {
                                System.out.println("Veículo presente no sistema.");
                                continue;
                            }

                            System.out.print("Insira a marca: ");
                            String marca = scanner.nextLine();
                            System.out.print("Insira o modelo: ");
                            String modelo = scanner.nextLine();

                            veiculo = new Moto(placa, marca, modelo);
                            veiculo.cadastroConcluido();
                            listaVeiculos.add(veiculo);
                            ManipulacaoDados.salvarDados(listaVeiculos);
                        } else if (tipo == 2) {
                            System.out.println();
                            System.out.print("Insira a placa: ");
                            String placa = scanner.nextLine();
                            System.out.print("Insira a marca: ");
                            String marca = scanner.nextLine();
                            System.out.print("Insira o modelo: ");
                            String modelo = scanner.nextLine();

                            veiculo = new Carro(placa, marca, modelo);
                            veiculo.cadastroConcluido();
                            listaVeiculos.add(veiculo);
                            ManipulacaoDados.salvarDados(listaVeiculos);
                        } else {
                            System.out.println();
                            System.out.println("Opção inválida! Tente novamente!");
                            System.out.println();
                        }
                    }

                } catch (InputMismatchException error) {
                    System.out.println("A opção deve ser somente números!");
                    break;
                }
                if (opcao == 2) {
                    System.out.println("Listagem de veículos!");

                    if (listaVeiculos.isEmpty()) {
                        System.out.println("Não há nenhum veículo cadastrado!");
                    } else {
                        for (Veiculo veiculo : listaVeiculos) {
                            System.out.println("--------------------");
                            veiculo.exibirDados();
                            System.out.println("--------------------");
                        }
                    }
                } else if (opcao == 3) {
                    System.out.print("Insira a placa do veículo que deseja atualizar: ");
                    String placaBusca = scanner.nextLine();

                    Veiculo veiculo = Busca.buscarPorPlaca(listaVeiculos, placaBusca);

                    if (veiculo == null) {
                        System.out.println("O veículo não está cadastrado no sistema.");
                    }
                    try {
                        System.out.print("Insira a nova placa: ");
                        String placa = scanner.nextLine();
                        veiculo.setPlaca(placa);
                        System.out.print("Insira a nova marca: ");
                        String marca = scanner.nextLine();
                        veiculo.setMarca(marca);
                        System.out.print("Insira o modelo do veículo: ");
                        String modelo = scanner.nextLine();
                        veiculo.setModelo(modelo);
                        System.out.println("Dados atualizados com sucesso!");
                    } catch (Exception error) {
                        System.out.println(error.getMessage());
                    }
                    ManipulacaoDados.salvarDados(listaVeiculos);
                } else if (opcao == 4) {
                    System.out.print("Insira a placa do veículo que deseja remover: ");
                    String placaBusca = scanner.nextLine();

                    Veiculo veiculo = Busca.buscarPorPlaca(listaVeiculos, placaBusca);

                    if(veiculo != null){
                        listaVeiculos.remove(veiculo);
                        System.out.println();
                        System.out.printf("Veículo com a placa %s foi removido com sucesso!", placaBusca);
                        System.out.println();
                    } else {
                        System.out.println("Veículo não está presente no cadastro!");
                    }
                    ManipulacaoDados.salvarDados(listaVeiculos);
                } else if (opcao == 5){
                    System.out.println();
                    System.out.println("********************");
                    System.out.println("BEM VINDO À OFICINA!");
                    System.out.println("********************");
                    System.out.println();

                    System.out.print("Insira a placa do veículo que deseja consertar: ");
                    String placaBusca = scanner.nextLine();

                    Veiculo veiculo = Busca.buscarPorPlaca(listaVeiculos, placaBusca);

                    if(veiculo == null){
                        System.out.println("Veículo não cadastrado!");
                    } else {
                        ((OperacoesVeiculo) veiculo).realizarManutencao();
                    }
                }
            }
            scanner.close();
    }
}

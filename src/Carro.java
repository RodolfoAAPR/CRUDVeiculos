public class Carro extends Veiculo implements OperacoesVeiculo {

    public Carro(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    @Override
    public void exibirDados() {
        System.out.println("*******CARRO*******");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
    }

    @Override
    public void realizarManutencao() {
        System.out.println();
        System.out.printf("O veículo com a placa %s foi consertado!", getPlaca());
        System.out.println();
    }
}

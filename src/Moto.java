public class Moto extends Veiculo implements OperacoesVeiculo{
    public Moto(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    @Override
    public void realizarManutencao() {
        System.out.printf("A moto com a placa %s foi consertada!", getPlaca());
    }

    @Override
    public void exibirDados() {
        System.out.println("*******MOTO*******");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
    }
}

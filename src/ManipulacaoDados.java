import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ManipulacaoDados {

    private static final String ARQUIVO = "veiculos.txt";

    public static void carregarDados(List<Veiculo> lista) {
        try {
            for (String linha : Files.readAllLines(Paths.get(ARQUIVO))) {
                String[] f = linha.split(";");
                if (f.length == 4) {
                    String tipo  = f[0];
                    String placa = f[1];
                    String marca = f[2];
                    String modelo= f[3];
                    Veiculo v = tipo.equalsIgnoreCase("Carro")
                            ? new Carro(placa, marca, modelo)
                            : new Moto (placa, marca, modelo);
                    lista.add(v);
                }
            }
        } catch (IOException ignored) { }
    }

    public static void salvarDados(List<Veiculo> lista) {
        var linhas = lista.stream()
                .map(v -> String.join(";",
                        v instanceof Carro ? "Carro" : "Moto",
                        v.getPlaca(),
                        v.getMarca(),
                        v.getModelo()))
                .toList();
        try {
            Files.write(Paths.get(ARQUIVO), linhas);
        } catch (IOException ignored) { }
    }
}
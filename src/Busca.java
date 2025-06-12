import java.util.ArrayList;

public class Busca{
    public static Veiculo buscarPorPlaca(ArrayList<Veiculo> listaVeiculos, String placa) {
        for (Veiculo v : listaVeiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}

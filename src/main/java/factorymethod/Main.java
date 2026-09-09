package factorymethod;

public class Main {

    public static void main(String[] args) {
        String[] tipos = {"Caminhao", "Navio", "Aviao", "Drone"};

        for (String tipo : tipos) {
            ITransporte transporte = TransporteFactory.obterTransporte(tipo);
            System.out.println(transporte.entregar());
            System.out.println(transporte.rastrear());
            System.out.println();
        }
    }
}

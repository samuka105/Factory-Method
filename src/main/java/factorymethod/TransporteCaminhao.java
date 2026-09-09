package factorymethod;

public class TransporteCaminhao implements ITransporte {

    public String entregar() {
        return "Entrega por caminhão efetivada (rota terrestre)";
    }
    public String rastrear() {
        return "Rastreando caminhão na rodovia";
    }
}

package factorymethod;

public class TransporteDrone implements ITransporte {

    public String entregar() {
        return "Entrega por drone efetivada (última milha)";
    }
    public String rastrear() {
        return "Rastreando drone em tempo real";
    }
}

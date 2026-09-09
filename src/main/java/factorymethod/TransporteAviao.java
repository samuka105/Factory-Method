package factorymethod;

public class TransporteAviao implements ITransporte {

    public String entregar() {
        return "Entrega por avião efetivada (rota aérea)";
    }
    public String rastrear() {
        return "Rastreando voo";
    }
}

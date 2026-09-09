package factorymethod;

public class TransporteNavio implements ITransporte {

    public String entregar() {
        return "Entrega por navio efetivada (rota marítima)";
    }
    public String rastrear() {
        return "Rastreando navio em alto-mar";
    }
}

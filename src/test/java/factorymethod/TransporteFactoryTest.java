package factorymethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TransporteFactoryTest {

    @ParameterizedTest
    @DisplayName("Deve instanciar a classe concreta correta para cada tipo")
    @CsvSource({
            "Caminhao, factorymethod.TransporteCaminhao",
            "Navio,    factorymethod.TransporteNavio",
            "Aviao,    factorymethod.TransporteAviao",
            "Drone,    factorymethod.TransporteDrone"
    })
    void deveCriarClasseConcretaCorreta(String tipo, String classeEsperada) {
        ITransporte transporte = TransporteFactory.obterTransporte(tipo);

        assertNotNull(transporte, "A fábrica não deveria devolver null");
        assertEquals(classeEsperada, transporte.getClass().getName());
    }

    @Test
    @DisplayName("O objeto devolvido deve ser do tipo ITransporte")
    void deveDevolverTipoDaInterface() {
        ITransporte transporte = TransporteFactory.obterTransporte("Caminhao");

        assertTrue(transporte instanceof ITransporte);
    }

    @Test
    @DisplayName("Caminhao deve entregar e rastrear com as mensagens corretas")
    void caminhaoDeveResponderCorretamente() {
        ITransporte transporte = TransporteFactory.obterTransporte("Caminhao");

        assertEquals("Entrega por caminhão efetivada (rota terrestre)",
                transporte.entregar());
        assertEquals("Rastreando caminhão via GPS na rodovia",
                transporte.rastrear());
    }

    @Test
    @DisplayName("Drone deve entregar com a mensagem correta")
    void droneDeveEntregarCorretamente() {
        ITransporte transporte = TransporteFactory.obterTransporte("Drone");

        assertEquals("Entrega por drone efetivada (última milha)",
                transporte.entregar());
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException para tipo inexistente")
    void deveLancarExcecaoParaTipoInexistente() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> TransporteFactory.obterTransporte("Foguete")
        );

        assertEquals("Transporte inexistente", erro.getMessage());
    }
}

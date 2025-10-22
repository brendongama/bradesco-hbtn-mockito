import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadoraTest {

    @Test
    public void testCalcularSomaComMock() {
        ServicoMatematico servicoMock = mock(ServicoMatematico.class);
        when(servicoMock.somar(2, 3)).thenReturn(5);

        Calculadora calculadora = new Calculadora(servicoMock);
        int resultado = calculadora.calcularSoma(2, 3);

        assertEquals(5, resultado);
        verify(servicoMock).somar(2, 3);
    }
}

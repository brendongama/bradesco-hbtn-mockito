import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaSimulada = new Conta("123", 1000.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("123")).thenReturn(contaSimulada);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("123");

        // Verificando se o saldo está correto
        assertEquals(1000.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepositoryMock).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaSimulada = new Conta("456", 500.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("456")).thenReturn(contaSimulada);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Executando depósito
        bancoService.depositar("456", 200.0);

        // Verificando se o saldo foi atualizado
        assertEquals(700.0, contaSimulada.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepositoryMock).buscarConta("456");
        verify(contaRepositoryMock).salvar(contaSimulada);
    }
}

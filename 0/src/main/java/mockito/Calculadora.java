public class Calculadora {

    private ServicoMatematico servico;

    public Calculadora(ServicoMatematico servico) {
        this.servico = servico;
    }

    public int calcularSoma(int a, int b) {
        return servico.somar(a, b);
    }
}
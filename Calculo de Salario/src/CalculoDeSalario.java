import java.util.Scanner;

public class CalculoDeSalario {
    /**
     * <h1> Desenvolva + | #1322 - Cálculo de Salário </h1>
     * Enunciado do Projeto
     * Faça um programa que receba 5 salários brutos de funcionários, sabendo-se que são descontados Imposto de Renda e INSS, calcule e mostre o total do salário líquido no referido mês.<br><br>
     *
     * Obs.: Salário Bruto - Descontos = Salário Líquido.<br><br>
     *
     * A saída do programa deve fornecer as seguintes informações:<br><br>
     *
     * Salário bruto.<br>
     * Quanto pagou ao INSS.<br>
     * Quanto pagou de Imposto de Renda.<br>
     * Salário líquido.<br><br>
     * Calcule os descontos e o salário líquido com base nas tabelas abaixo:<br><br>
     *
     * Salário	% Desconto INSS<br><br>
     * até 1.212,00	7,5%<br>
     * de 1212,01 até 2.427,35	9%<br>
     * de 2.427,36 até 3.641,03	12%<br>
     * de 3.641,04 até 7.087,22	14%<br><br>
     * Salário	% Desconto Imposto de Renda<br><br>
     * até 1.903,98	0%<br>
     * de 1.903,99 até 2.826,65	7,5%<br>
     * de 2.826,66 até 3.751,05	15%<br>
     * de 3.751,06 até 4.664,68	22,50%<br>
     * Acima de 4.664,68	27,50%<br><br>
     * <p>
     * <b>Note:</b> Desenvolvido na linguagem Java.
     *
     * @author Marcos Ferreira Shirafuchi
     * @version 1.0
     * @since 09/01/2025
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salarioBruto = new double[5];
        double[] valorDoInss = new double[5];
        double[] valorDoImpostoDeRenda = new double[5];
        double[] salarioLiquido = new double[5];
        for (int i = 0; i < 5; i++){
            System.out.printf("Digite o valor do salario do %dº funcionário: ", i+1);
            salarioBruto[i] = scanner.nextDouble();
            System.out.printf("Valor do Salário Bruto do %dº funcionário:  R$ %.2f\n", i+1, salarioBruto[i]);
            valorDoInss[i] = calculoDoInss(salarioBruto[i]);
            System.out.printf("Valor do INSS do %dº funcionário: R$ %.2f\n", i+1,valorDoInss[i]);
            valorDoImpostoDeRenda[i] = calculoDoImpostoDeRenda(salarioBruto[i]);
            System.out.printf("Valor do Imposto de Renda do %dº funcionário: R$ %.2f\n", i+1, valorDoImpostoDeRenda[i]);
            salarioLiquido[i] = salarioBruto[i] - valorDoInss[i] - valorDoImpostoDeRenda[i];
            System.out.printf("Valor do Salário Líquido do %dº funcionário: R$ %.2f\n", i+1, salarioLiquido[i]);
            System.out.println();
        }
        scanner.close();
    }

    private static double calculoDoInss(double salario) {
        double deducao;
        double aliquota;
        double valorAPagar = 0;
        if(salario <= 1212.00){
            aliquota = 7.5;
            deducao = 0;
            valorAPagar = salario * aliquota/100 - deducao;
        } else if (salario <= 2427.35) {
            aliquota = 9;
            deducao = 21.18;
            valorAPagar = salario * aliquota/100 - deducao;
        } else if (salario <= 3641.03) {
            aliquota = 12;
            deducao = 101.18;
            valorAPagar = salario * aliquota/100 - deducao;
        }else if (salario <= 7087.22){
            aliquota = 14;
            deducao = 181.18;
            valorAPagar = salario * aliquota/100 - deducao;
        }else{
            aliquota = 14;
            deducao = 181.18;
            valorAPagar = 7087.22 * aliquota/100 - deducao;
        }
        return valorAPagar;
    }

    private static double calculoDoImpostoDeRenda(double salario) {
        double deducao;
        double aliquota;
        if ( salario <= 1903.98){
            aliquota = 0;
            deducao = 0;
        }else if (salario <= 2826.65){
            aliquota = 7.5/100;
            deducao = 169.44;
        }else if(salario <= 3751.05){
            aliquota = 15.0/100;
            deducao = 381.44;
        } else if (salario <=4664.68) {
            aliquota = 22.5/100;
            deducao = 662.77;
        }else{
            aliquota = 27.5/100;
            deducao = 896.00;
        }
        return salario * aliquota - deducao;
    }
}

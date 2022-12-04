package tarefa5_optional_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploException {

    public static int calcularQuociente(int dividendo, int divisor) throws ArithmeticException {
        return dividendo / divisor;
    }

    public static void main(String[] args) {
        int dividendo, divisor, resultado;
        Scanner leitor = new Scanner(System.in);
        boolean continua = true;

        do {
            try {
                System.out.print("Dividendo: ");
                dividendo = leitor.nextInt();
                System.out.print("Divisor: ");
                divisor = leitor.nextInt();
                resultado = calcularQuociente(dividendo, divisor);
                System.out.println("Resultado: " + resultado);

                continua = false;

            } catch (InputMismatchException erro1) {
                System.err.println("Entrada Inválida, informe somente inteiros!");
                leitor.nextLine();
            } catch (ArithmeticException erro2) {
                System.err.println("O divisor deve ser diferente de 0!");
            }
        } while (continua);

        leitor.close();
    }

}

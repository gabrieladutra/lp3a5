package tarefa5_optional_exceptions;
import java.util.Optional;
/*
Referencia - Aula de Optional - Youtube
* */
public class Main {
    public static void main(String[] args) {
        String mensagem = "Meu teste";
        System.out.println(getValorInteiroOf(mensagem));
        System.out.println(getValorInteiroNullable(null));
    }


    // contem inteiro ou nao -> opcional Of e Value OFF
//    public static Optional<Integer> getValorInteiro (String numeroStr){
//        return Optional.of(Integer.valueOf(numeroStr));
//    }

    public static Optional<Integer> getValorInteiroOf (String numeroStr) {
        try {
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        } catch (Exception e){
            return Optional.empty();
        }
    }
    public static Optional<String> getValorInteiroNullable (String numeroStr) {
            return Optional.ofNullable(numeroStr);
    }




}

package tarefa5_optional_exceptions;

import java.util.Optional;

public class ExemploOptional {

    public static void main(String[] args) {
        Optional<String> mensagem = Optional.of("Hello World!");
        String saudacao = "Bom dia!";

        System.out.println("Optional empty() " + Optional.empty());
        System.out.println("Optional get(_) " + mensagem.get());
        System.out.println("OPTIONAL preenchido " + mensagem);

        System.out.println("Of() " + Optional.of(null));
        System.out.println("" + Optional.ofNullable(saudacao));
        System.out.println("OfNullable" + Optional.ofNullable(null));

    }
}

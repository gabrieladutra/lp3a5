package tarefa4_programacao_funcional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paises {
        public static void main(String[] args) {

                String[] paises = {"Brasil", "França", "Argentina", "Australia", "Uruguai"};

                System.out.println("\nListagem - toList(): ");
                List<String> listaDePaises = Paises.recuperarLista(paises);
                listaDePaises.forEach(System.out::println);

                System.out.println("\n Mapa - toMap(): ");
                Map<String, Integer> paisesMap = Paises.mapearLista(listaDePaises);
                paisesMap.forEach((key, value) -> {
                    System.out.println(key + " tem " + value + " letras");
                });

                System.out.println("\n Conjunto - toSet(): ");
                Set<String> conjuntoDePaises = Paises.getSet(paises);
                conjuntoDePaises.forEach(System.out::println);

                System.out.println("\n Contador - toCount(): ");
                System.out.println("O grupo tem " + Paises.recuperartamanhoDaString(paises) + " paises.");

                System.out.println("\n Agrupamento - toJoin(): ");
                System.out.println("Todos os nomes dos paises juntos:  " + Paises.join(paises));
            }


            public static List<String> recuperarLista(String[] paises) {
                return Stream.of(paises).collect(Collectors.toList());
            }

            public static Map<String, Integer> mapearLista(List<String> listaDePaises) {
                Map<String, Integer> map = new HashMap<>();

                listaDePaises.forEach(
                        (friend) -> map.put(friend, friend.length())
                );
                return map;
            }

            public static Set<String> getSet(String[] paises) {
                return Stream.of(paises).collect(Collectors.toSet());
            }

            public static Long recuperartamanhoDaString(String[] paises) {
                return Stream.of(paises).count();
            }

            public static String join(String[] paises) {
                return Stream.of(paises).collect(Collectors.joining());
            }

}


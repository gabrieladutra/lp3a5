package tarefa4_programacao_funcional;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Collector de List
        List<Integer> numeros = Arrays.asList(1, 99,2,444,32,7,44,1,99,2,198,777);
        System.out.println(getImpares(numeros));
        getDobro(numeros);

        Stream<String> sequencia = Stream.of("333", "36", "45","9","108");
        List<String> listaCollector = sequencia.collect(Collectors.toList());
        System.out.println( listaCollector );
        System.out.println(getListaSemValoresRepetidos(numeros));

    }
    public static List<Integer> getImpares (List<Integer> lista){
        return lista.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
        }

        // MAP
        public static void getDobro(List<Integer> lista){
        lista.stream().map(numero -> numero * 2).forEach(e -> System.out.print(e + " "));
        }

        //SET
    public static Set<Integer> getListaSemValoresRepetidos(List<Integer> lista){
        return new HashSet<>(lista);
    }

}


package ar.edu.unq.obj3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejemplos {

    public static class MapeableList<T> extends ArrayList<T> {
        public <K> List<K> map(Transformer<T,K> transformer) {
            List<K> transformed = new ArrayList<>();
            for (T elem : this) {
                transformed.add(transformer.transform(elem));
            }
            return transformed;
        }
    }

    public interface Transformer<T,K> {
        public K transform(T object);
    }

    public static class Example {
        public void main(String[] args) {
            MapeableList<String> nombres = new MapeableList<>();
            nombres.add("Juan");
            nombres.add("Pedro");
            nombres.add("Emiliano");

            List<Integer> tamanios =
                    nombres.map(String::length);

            Object o = tamanios.get(0);
        }
    }

}

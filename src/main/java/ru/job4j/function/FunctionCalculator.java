package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionCalculator {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {

        Supplier<List<Double>> sup = ArrayList::new;
        Function<Integer, Double> fun = Integer::doubleValue;
        BiConsumer<List<Double>, Double> consumer = List::add;
        List<Double> arrayList = sup.get();
        for (int i = start; i < end; i++) {

            consumer.accept(arrayList, func.apply(fun.apply(i)));
        }
        return arrayList;
    }
}

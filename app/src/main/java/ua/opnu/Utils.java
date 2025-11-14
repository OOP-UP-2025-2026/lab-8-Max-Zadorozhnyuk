package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Utils {

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                input.getClass().getComponentType(), input.length);
        int counter = 0;
        for (T t : input)
            if (p.test(t))
                result[counter++] = t;
        return Arrays.copyOfRange(result, 0, counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T t : array)
            if (t.equals(element))
                return true;
        return false;
    }
}
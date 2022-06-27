package runstatic.leetcode.annotation;


import java.util.*;

public class Test {
    public static class CustomInput {
        private BaseInput<Example> exampleBaseInput;
    }

    public static class BaseInput<T> {
        private T data;
    }
    public static class Example{
        protected List<String> list = new ArrayList<>();
        protected List<Integer> list2 = new ArrayList<>();
        protected Set<String> set = new HashSet<>();
        protected Set<Integer> set2 = new HashSet<>();
        protected Map<String,String> map = new HashMap<>();
        protected Map<String,Integer> map2 = new HashMap<>();
    }
}

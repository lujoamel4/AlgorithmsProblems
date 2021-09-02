import java.util.*;

public class Main {

    static class Pair {
        int a;
        int b;
        int sum;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
        }

        public int getSum() {
            return sum;
        }

    }

    public static int findMaxSum(List<Integer> list) {
        if (list.size() == 0){
            return 0;
        }

        List<Pair> pairs = generateAllPairs(list);

        return pairs.parallelStream().max((p1, p2) -> {
            if (p1.getSum() < p2.getSum()) {
                return -1;
            } else if (p1.getSum() == p2.getSum()) {
                return 0;
            } else {
                return 1;
            }

        }).get().getSum();
    }

    private static List<Pair> generateAllPairs(List<Integer> list) {
        List<Pair> pairs = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < j; i++) {
                if (j != i) {
                    pairs.add(new Pair(list.get(i), list.get(j)));
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list)); // should be equal to 20

        list = Arrays.asList(5, 9, 7, 11, 2, 4 ,5 ,6 ,7 ,8 , 9);
        System.out.println(findMaxSum(list));//  should be equal to 20

        list = Arrays.asList();
        System.out.println(findMaxSum(list));//  should be equal to 0
    }

}


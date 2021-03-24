public class TestSizeA {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();
        GenericListQueue<Integer> al = new GenericListQueue<Integer>();
        final int len = 100;
        for (int i = 0; i < len; i++) {
            aq.enq(i);
            al.enq(i);
        }
        if (aq.size() != al.size()) {
            StdOut.println("The two queues do not have the same size!");
            System.exit(1);
        }

        if (al.size() != len) {
            StdOut.printf("The queue should have a length of %d, instead it has %d\n", len,
                          al.size());
            System.exit(1);
        }

        StdOut.println("Test passed!");
    }
}

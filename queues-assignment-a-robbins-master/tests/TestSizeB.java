public class TestSizeB {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();
        GenericListQueue<Integer> lq = new GenericListQueue<Integer>();
        final int len = 100;
        for (int i = 0; i < len; i++) {
            aq.enq(i);
            lq.enq(i);
        }

        while (!aq.isEmpty()) {
            aq.deq();
        }
        if (aq.size() != 0) {
            StdOut.println("Queue should be empty but it says its not");
            System.exit(1);
        }
        while (!lq.isEmpty()) {
            lq.deq();
        }
        if (lq.size() != 0) {
            StdOut.println("Queue should be empty but it says its not");
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}

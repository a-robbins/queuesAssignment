public class TestEmptyDeqC {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();
        GenericListQueue<Integer> al = new GenericListQueue<Integer>();
        final int len = 100;

        for (int i = 0; i < len; i++) {
            aq.enq(i);
        }
        for (int i = 0; i < len; i++) {
            aq.deq();
        }
        if (aq.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }

        for (int i = 0; i < len; i++) {
            al.enq(i);
        }
        for (int i = 0; i < len; i++) {
            al.deq();
        }
        if (al.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}

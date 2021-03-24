public class TestEmptyDeqB {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();
        GenericListQueue<Integer> al = new GenericListQueue<Integer>();

        aq.enq(1);
        aq.deq();
        if (aq.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }

        al.enq(1);
        al.deq();
        if (al.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}

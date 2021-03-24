public class TestEmptyDeqA {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();
        GenericListQueue<Integer> al = new GenericListQueue<Integer>();

        if (aq.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }
        if (al.deq() != null) {
            StdOut.println("deq() on an empty queue should return null");
            System.exit(1);
        }
        StdOut.println("test passed!");
    }
}

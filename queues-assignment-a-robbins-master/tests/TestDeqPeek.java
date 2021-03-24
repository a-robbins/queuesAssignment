
public class TestDeqPeek {
    public static void main(String[] args) {
        GenericArrayQueue<Integer> aq = new GenericArrayQueue<Integer>();

        for (int i = 0; i < 6; i++) { aq.enq(i); }
        aq.print();
        for (int i = 0; i < 3; i++) { aq.deq(); }
        aq.print();
        for (int i = 0; i < 4; i++) { aq.enq(i); }
        aq.print();

        for (int i = 0; i < 8; i++) {
            StdOut.println(aq.deq());
        }

        aq.print();
        if (!aq.isEmpty() && aq.peek() == null) { StdOut.println("peek is null when it shouldn't be"); System.exit(1); }
        else { StdOut.println("test passed!"); }
    }

}

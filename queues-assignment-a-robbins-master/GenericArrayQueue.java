/*
 * Use this file to implement the GenericArrayQueue class. This class should
 * represent a queue which uses a dynamic array to store data. This means that
 * the array should be allowed to grow and shrink to fit the required amount of
 * data. This should follow the same growth/shrinking pattern we discussed in the
 * lecture videos where the array will be doubled in size whenever the maximum
 * capacity has been met, and shrunk by half whenever the array is only currently
 * a quarter full. The output from this file should exactly match the output generated
 * by the GenericListQueue class when given the same input
 *
 * Remember that there should be a distinction between the current size of the
 * array and the current number of elements in the array that are actively being
 * used. The array size should only be changed when the _actively_ used capacity
 * has reached that threshold.
 *
 * So for instance lets assume we have an array with an overall capacity of 8 but
 * only 4 items are stored in the array, however the layout of the data in the
 * array is as follows
 *
 *             Front +
 *                   |
 *                   |
 * +---+---+---+---+-v-+---+---+---+
 * |   |   |   |   | + | + | + | + |
 * +---+---+---+---+---+---+---+---+
 *                               ^
 *                               |
 *                     Back+-----+
 *
 * In this instance the array should _not_ be resied on the next call to enqueue
 * as there are still open slots in the array that can be used to store data. Instead,
 * on the next call to enqueue the Back pointer should wrap back around to the
 * front of the queue in order to take advantage of the remaining open slots in
 * the array
 *
 *             Front +
 *                   |
 *                   |
 * +---+---+---+---+-v-+---+---+---+
 * | + |   |   |   | + | + | + | + |
 * +---+---+---+---+---+---+---+---+
 *   ^
 *   |
 *   +-----+Back
 *
 * And only once all array elements are used should the array size be increased
 *
 *             Front +
 *                   |
 *                   |
 * +---+---+---+---+-v-+---+---+---+
 * | + | + | + | + | + | + | + | + |
 * +---+---+---+---+---+---+---+---+
 *               ^
 *               |
 *               +-----+Back
 *
 * Once this criteria has been met, then the next call to enqueue should yield
 * an array that has been doubled in size
 *
 *
 *   + Front
 *   |
 *   |
 * +-v-+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 * | + | + | + | + | + | + | + | + |   |   |   |   |   |   |   |   |
 * +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
 *                               ^
 *                               |
 *                               +-----+Back
 *
 *
 */
public class GenericArrayQueue<Item> {

    /***************************************************************************
     * Private Instance Variables
     **************************************************************************/
    // The index that currently represents the front of the queue
    private int front;
    // The index that currently represents the next open slot in the array
    private int back;
    // The current number of actively used array slots
    private int N;
    // The array that we're using to store our data
    private Item[] dataArray;

    /***************************************************************************
     * Public Instance Methods
     **************************************************************************/

    /**
     * Our constructor, initializes our isntance variables and creates our storage
     * array. Remember that the array should start off with a size of 1
     */
    public GenericArrayQueue() {
        dataArray = (Item[]) new Object[1];
        front = 0;
        back = 0;
        N = 0;
    }

    /**
     * Adds a new item to our queue, this will resize the array if necesary. Note
     * that the array should only be resized if all open slots in the array have
     * been filled. See the notes at the top of this file to see how you could
     * run into a situation where the 'front' of the queue may wrap around from
     * the end of the array back to the front of the array
     *
     * @return true if the data was inserted succesfully, false if it was not
     */
    public boolean enq(Item item) {
        if (dataArray.length == N) { resize(2 * dataArray.length); }
        if (back != dataArray.length) {
            dataArray[back] = item;
            back++;
            N++;
        }
        else {
            back = 0;
            if (back != front) {
                dataArray[back] = item;
                back++;
                N++;
            }
        }
        return true;
    }


    /**
     * Removes the front item from our queue, this will resize the array if necesary.
     *
     * @return The item that was removed from the queue or null if the queue was
     * empty
     */
    public Item deq() {
        if (N > 0 && N == dataArray.length/4) { resize(dataArray.length/2); }
        if (!isEmpty() && front >= dataArray.length-1) {
            front = 0;
            Item val = dataArray[front];
            dataArray[front] = null;
            front++;
            N--;
            return val;
        }
        else if (!isEmpty() && front != dataArray.length-1) {
            Item val = dataArray[front];
            dataArray[front] = null;
            front++;
            N--;
            return val;
        }
        return null;
    }

    /**
     * Returns the number of actively used array elements
     */
    public int size() {
        return N;
    }

    /**
     * Checks to see if the queue contains data or not
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        if (N == 0) { return true; }
        else return false;
    }

    /**
     * prints the contents of the queue from front to back in the same format
     * as printed in the GenericListQueue class
     */
    public void print() {
       StdOut.print("front --> ");
            for (int i = front; i < dataArray.length; i++) {
                if (dataArray[i] != null) {
                    StdOut.print(dataArray[i] + " --> ");
                }
            }
            StdOut.print("back\n");
    }

    /**
     * Resizes the data array to an appropriate size. This can be used to grow
     * and shrink the array as necesary. The contents of the old array should
     * then be copied to the new array
     *
     * @param newCap The new maximum capacity for the array.
     */
    private void resize(int newCap) {
        Item[] copy = (Item[]) new Object[newCap];
        int frontVal = front;
        for (int i = 0; i < N; i++) {
            copy[i] = dataArray[frontVal];
            if ((frontVal < N-1) || (frontVal >= N && frontVal < dataArray.length)) { frontVal++; }
            else { frontVal = 0; }
        }
        dataArray = copy;
        front = 0;
        back = N;
    }

        /**
         * Returns the data that is currently at the front of the queue without
         * removing that data. This should be a O(1) operation
         *
         * @return the data that is at the front of the queue or null if the queue
         * is empty
         */
        public Item peek() { return dataArray[front]; }

        public static void main (String[]args) {
            GenericArrayQueue<String> q = new GenericArrayQueue<String>();
            StdOut.println("Accepting input");
            while (!StdIn.isEmpty()) {
                StdOut.print("> ");
                String cmd = StdIn.readString();
                StdOut.println("calling " + cmd);
                if (cmd.equals("quit")) {
                    StdOut.println("quitting!");
                    break;
                }
                else if (cmd.equals("size")) {
                    StdOut.printf("size: %d\n", q.size());
                }
                else if (cmd.equals("deq")) {
                    if (q.size() > 0) {
                        String data = q.deq();
                        if (data != null) {
                            StdOut.println("dequeued " + data);
                        }
                        else {
                            StdOut.println("error: got null back when we shouldn't have!");
                        }
                    }
                    else {
                        StdOut.println("queue is empty");
                    }
                }
                else if (cmd.equals("peek")) {
                    if (!q.isEmpty()) {
                        String data = q.peek();
                        if (data == null) {
                            StdOut.println("error: got null back when we shouldn't have!");
                        }
                        else {
                            StdOut.println("front: " + data);
                        }
                    }
                    else {
                        StdOut.println("queue is empty");
                    }
                }
                else if (cmd.equals("print")) {
                    q.print();
                }
                else if (cmd.equals("enq")) {
                    if (!q.enq(StdIn.readString())) {
                        StdOut.println("error: enqueue failed!");
                    }
                }
                else if (cmd.equals("isEmpty")) {
                    if (q.isEmpty()) {
                        StdOut.println("queue is empty");
                    }
                    else {
                        StdOut.println("queue is not empty");
                    }
                }
                else {
                    StdOut.println("error: unknown cmd " + cmd);
                }
            }
        }
    }


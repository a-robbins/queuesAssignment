/**
 * This queue should use a linked list as its real data store. Ideally you will
 * create a seperate `GenericList.java` file which implements the linked list
 * logic and then you can create a private instance of that linked list for use
 * by this class. If done correctly this file will have very little code in it as
 * each part of the queue API will just be implemented by calling the appropriate
 * linked list API function
 *
 * @param <Item> The type of data that will be stored in this queue
 */
public class GenericListQueue<Item> {

    /**
     * This queue will use our generic list as our backing data store, create
     * an instance variable here which can be used by our other methods
     */
    private GenericList<Item> list;

    /**
     * This is the constructor for our GenericListQueue class. It should initialize
     * the linked list which will be used as the real data store for our queue
     * data.
     */
    public GenericListQueue() {
        list = new GenericList<Item>();
    }

    /**
     * Inserts data into our queue. Since we are using a linked list as our
     * backing data store this API function should just call the appropriate
     * linked list API function. This should be a O(1) operations
     *
     * @param item The data to insert into our queue
     * @return true if the data was inserted succesfully, false if it was not
     */
    public boolean enq(Item item) {
        return list.insertBack(item);
    }

    /**
     * Returns the data that is currently at the front of the queue without
     * removing that data. This should be a O(1) operation
     *
     * @return the data that is at the front of the queue or null if the queue
     * is empty
     */
    public Item peek() {
        return list.getFront();
    }

    /**
     * Removes the front element of the queue and returns a reference to that
     * data. This function should make sure that there is data to return and
     * should return null if there is no data to return. This should be a O(1)
     * operations
     *
     * @return The data that was at the front of the queue or null if the queue
     * was empty
     */
    public Item deq() {

        if(list.isEmpty()) { return null; }
        Item a = list.getFront();
        list.deleteFront();
        return a;
    }

    /**
     * Returns the number of items currently stored in the queue. This method
     * should be a O(1) operations
     *
     * @return The number of items in the queue
     */
    public int size() { return list.getSize(); }

    /**
     * Prints the contents of the queue from front to back. See the files in
     * output/ for examples of the formatting for this function. Note that your
     * formatting must match mine exactly for it to pass the unit tests.
     */
    public void print() {
        StdOut.print("front --> ");
        for(Item i : list) { StdOut.print(i + " --> "); }
        StdOut.print("back\n");
    }

    /**
     * Checks to see if the queue contains data or not
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
       return list.isEmpty();
    }

    /**
     * This is our main test client. This can be invoked either by running this
     * file in Intellij or by building and running the program on the command
     * line. Once started, this program will read commands from stdin and take
     * the associated operation on our data structure
     * <p>
     * This can be used to manually test various pieces of functionality either
     * by you running the program and manually typing commands in or by entering
     * commands into a text file and using input redirection to automatically
     * send the contents of that file to your program.
     * <p>
     * See the code below to identify what commands the program accepts. Calls
     * to cmd.equals("<something>") indicate the commands the program is looking
     * for. Different commands may expect other pieces of data to be provided
     * as well, this can be identified by looking at the code that handles each
     * command
     */
    public static void main(String[] args) {
        GenericListQueue<String> q = new GenericListQueue<String>();
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

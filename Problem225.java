/*
225. Implement Stack using Queues

Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the
functions of a normal queue (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means only push to back, top/pop from front, size, and is
empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque
(double-ended queue), as long as you use only a queue's standard operations.
Follow-up: Can you implement the stack such that each operation is amortized O(1) time complexity? In other words,
performing n operations will take overall O(n) time even if one of those operations may take longer.


Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
*/


import java.util.LinkedList;
import java.util.Queue;

class Problem225 {
    class MyStack {
        private Queue<Integer> in = new LinkedList<>();
        private Queue<Integer> out = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {
        }

        /** Push element x to the back of stack. */
        public void push(int x) {
            inToOut();
            in.add(x);
            outToIn();
        }

        /** Removes the element from on top of stack and returns that element. */
        public int pop() {
            return in.poll();
        }

        /** Get the top element. */
        public int top() {
            return in.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void inToOut() {
            while (!in.isEmpty()) {
                out.add(in.poll());
            }
        }

        private void outToIn() {
            while (!out.isEmpty()) {
                in.add(out.poll());
            }
        }
    }


    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem225 pr = new Problem225();
        MyStack MyStack = pr.new MyStack();
        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);
        System.out.println("top:" + MyStack.top());
        System.out.println("pop:" + MyStack.pop());
        System.out.println("empty:" + MyStack.empty());

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

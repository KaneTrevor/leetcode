
/*
232. Implement Queue using Stacks

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque
(double-ended queue) as long as you use only a stack's standard operations.
Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words,
performing n operations will take overall O(n) time even if one of those operations may take longer.



Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

*/


import java.util.Stack;

class Problem155 {
    class MinStack {
        private Stack<Integer> st;
        private int min;

        public MinStack() {
            st = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x <= min) {
                st.push(min);
                min = x;
            }
            st.push(x);
        }

        public void pop() {
            int e = st.pop();
            if (e == min) {
                min = st.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }


    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem155 pr = new Problem155();
        MinStack minStack = pr.new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("peek:" + minStack.getMin());// return -3
        minStack.pop();
        System.out.println("empty:" + minStack.top()); // return 0
        System.out.println("pop:" + minStack.getMin()); // return -2

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

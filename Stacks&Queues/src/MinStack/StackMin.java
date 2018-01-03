package MinStack;
import java.util.Stack;

public class StackMin {

	/* How would you design a stack which,
	 * in addition to push and pop, has a 
	 * function min which returns the minimum
	 * element? Push, pop, and min should
	 * all operate in O(1) time
	 */
	
	/* Implement minStack using 2 Stacks
	 * of the java class Stack<E>.
	 * We use one stack to keep track of 
	 * the minimum and another to function
	 * as the regular Stack
	 * 
	 * Time: O(1) for all operations
	 */
	class minStack extends Stack<Integer> {
		Stack<Integer> s2;
		
		/* Constructor */
		public minStack() {
			s2 = new Stack<Integer>();
		}
		
		/* Push */
		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}
		
		/* Pop */
		public Integer pop() {
			int value = super.pop();
			if (value == min()) {
				s2.pop();
			}
			return value;
		}

		/* Min */
		public Integer min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}
}

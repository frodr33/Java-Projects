import java.util.EmptyStackException;
public class ThreeinOne {

	/* Three in One: Describe how to
	 *  use a single array to implement
	 *  three stacks
	 */
	
	/* Solution 1: Fixed Approach
	 * Array evenly split into 3 
	 * parts
	 */
	class FixedMultiStack {
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;
		
		// Constructor
		public FixedMultiStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numberOfStacks];
			sizes = new int[numberOfStacks];
		}
		
		/* Push Value onto Stack */
		public void push (int stackNum, int value){
			// Check that there is space for next elem
			if (isFull(stackNum)) {
				System.out.println("STACK FULL");
				
			} else {
				
				// Increment stack pointer and then update top value
				sizes[stackNum]++;
				values[indexOfTop(stackNum)] = value;				
			}
		}
		
		/* Pop item from top of Stack */
		public int pop(int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex]; // Get top
			values[topIndex] = 0; // Clear
			sizes[stackNum]--; // Shrink
			return value;
		}
		
		/* Return top element */
		public int peek (int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			
			return values[indexOfTop(stackNum)];
		}
		
		/* Return if stack is empty */
		public boolean isEmpty (int stackNum) {
			if (sizes[stackNum] == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		/* Return if stack is full */
		public boolean isFull (int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}
		
		/* Return index of the top of the stack */
		private int indexOfTop (int stackNum) {
			int offset = stackNum * stackCapacity;
			int top = sizes[stackNum] -1;
			return offset + top;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeinOne T = new ThreeinOne();
		FixedMultiStack FMS = T.new FixedMultiStack(10);
		FMS.push(1, 234);
	}
}

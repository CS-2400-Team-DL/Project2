package test;

import main.ResizeableArrayStack;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class EvaluatePostFixTest {
	
	// Test algorithm's ability to proper convert basic infix notation into postfix.
	@Test
	void BasicAddition(){
		String postfix = "29+";
		assertEquals("11", ResizeableArrayStack.evaluatePostfix(postfix));
	}
	
	@Test
	void BasicSubtraction(){
		String postfix = "63-";
		assertEquals("3", ResizeableArrayStack.evaluatePostfix(postfix));
	}

	@Test
	void BasicMultiplication(){
		String postfix = "57*";
		assertEquals("35", ResizeableArrayStack.evaluatePostfix(postfix));
	}

   @Test
	void BasicDivision(){
		String postfix = "93/";
		assertEquals("3", ResizeableArrayStack.evaluatePostfix(postfix));
	}

   @Test
	void BasicPower(){
		String postfix = "24^";
		assertEquals("16", ResizeableArrayStack.evaluatePostfix(postfix));
	}

   @Test
	void MultipleOperators(){
		String postfix = "49+6-";
		assertEquals("7", ResizeableArrayStack.evaluatePostfix(postfix));
	}

}

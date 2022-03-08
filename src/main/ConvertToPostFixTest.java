package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ConvertToPostFixTest {
	
	// Test algorithm's ability to proper convert basic infix notation into postfix.
	@Test
	void BasicInfixToPostfix(){
		String infix = "a/b";
		assertEquals("a b / ", LinkedStack.convertToPostFix(infix));
	}
	
	// Test algorithms ability to handle same precedent sysmbols. Should be interpreted left to right.
	@Test
	void EqualPrecedenceTest(){
		String infix = "a+b-c";
		assertEquals("a b + c - ", LinkedStack.convertToPostFix(infix));
	}

	// Test Algorithm's ability to properly output exponetial symbols and test the order at which they are placed.
	@Test
	void NestedExpontentialsTest(){
		String infix = "a^b^c";
		assertEquals("a b c ^ ^ ", LinkedStack.convertToPostFix(infix));
	}
 
	// Test algorihm's ability to ignore non-math symbols and handle many diffrent operands at once.
	@Test
	void IgnoreNonMathSymbolsTest() {
		String infix = "a*_b + (c#/d) ^ e  ";
		assertEquals("a b * c d / e ^ + ", LinkedStack.convertToPostFix(infix));
	}
	
	//Test algorithm's ability to handle different precendent operators.
	@Test
	void DifferentPrecedentTest() {
		String infix = "a+b*c";
		assertEquals("a b c * + ", LinkedStack.convertToPostFix(infix));
	}
	
	//Test algorithm's ability to handle multiple paranthesis in a single equation.
	@Test
	void DoubleParenthesisTest() {
		String infix = "(a+b)/(c-d)";
		assertEquals("a b + c d - / ", LinkedStack.convertToPostFix(infix));
	}
	//Test algorithm's ability to handle nested pearanthesis
	@Test
	void NestedParanthesisTest(){
		String infix = "((a+b)*e)/(c-d)";
		assertEquals("a b + e * c d - / ", LinkedStack.convertToPostFix(infix));
	}

	//Test the algorithm's ability to handle complex mixture of all available operands
	@Test
	void ComplexOperandTest(){
		String infix = "((a^b)^c)+d*e/d-f";
		assertEquals("a b ^ c ^ d e * d / + f - ", LinkedStack.convertToPostFix(infix));

	}

}

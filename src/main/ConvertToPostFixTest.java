package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ConvertToPostFixTest {
	
	@Test
	void ConverToPostfixTest() {
		String infix = "a*_b + (c#/d) ^ e  ";
		assertEquals("a b * c d / e ^ + ", LinkedStack.convertToPostFix(infix));
	}
	
	@Test
	void ConverToPostfixTest1() {
		String infix = "a*b+c";
		assertEquals("a b * c + ", LinkedStack.convertToPostFix(infix));
	}
	
	@Test
	void ConverToPostfixTest2() {
		String infix = "(a+b)/(c-d)";
		assertEquals("a b + c d - / ", LinkedStack.convertToPostFix(infix));
	}
	
	
}

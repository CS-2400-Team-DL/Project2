package main;

public class ArrayStackedTest {

    public static void main(String[] args){
        
        String Task1postfix = LinkedStackTest.getPostfix();
        System.out.println("\nPostfix equation: " + Task1postfix + "\n");
    	
        Task1postfix = Task1postfix.replace('a', '2');
        Task1postfix = Task1postfix.replace('b', '3');
        Task1postfix = Task1postfix.replace('c', '4');
        Task1postfix = Task1postfix.replace('d', '5');
        Task1postfix = Task1postfix.replace('e', '6');
        Task1postfix = Task1postfix.replaceAll("\\s", "");
        System.out.println("Replaced variables a=2, b=3, c=4, d=5, e=6 and removed spaces.");
        System.out.println("After substitution: " + Task1postfix);
        String result = ResizeableArrayStack.evaluatePostfix(Task1postfix);
		System.out.print("\npostfix: " + Task1postfix + "\nresult:" + result + "\n ");
    }
}
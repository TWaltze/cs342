package pa2;

public class Client {

	public static void main(String[] args) {
		StackArray<String> todo = new StackArray<String>();

		todo.push("clean kitchen").push("buy paper towels").push("cs342 homework");

		System.out.println(todo);
	}

}

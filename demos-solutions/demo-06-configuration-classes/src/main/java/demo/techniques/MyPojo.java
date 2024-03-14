package demo.techniques;

public class MyPojo {

	private int field1;
	private String field2;

	public MyPojo(int field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
		System.out.printf("Creating MyPojo, fields %d %s\n", field1, field2);
	}

	@Override
	public String toString() {
		return String.format("Hi! from MyPojo, fields %d %s", field1, field2);
	}
}
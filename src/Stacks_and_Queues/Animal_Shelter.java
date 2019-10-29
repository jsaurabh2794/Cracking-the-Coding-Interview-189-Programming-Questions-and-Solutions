package Stacks_and_Queues;


import java.util.LinkedList;

public class Animal_Shelter {

	static LinkedList<Cat> cats = new LinkedList<Cat>();
	static LinkedList<Dog> dogs = new LinkedList<Dog>();
    private static int order;
	public static void main(String[] args) {

		Animal a1 = new Cat("Cat1");
		Animal a2 = new Cat("Cat2");
		Animal a3 = new Dog("Dog1");
		enqueue(a1);
		enqueue(a2);
		enqueue(a3);
		System.out.println(dequequeAny().getName());
		System.out.println(dequeueDog().getName());

	}

	public static void enqueue(Animal animal)
	{
		animal.setOrder(order);
		order++;
		if(animal instanceof Cat)
		{
			cats.addLast((Cat)animal);
		}else
		{
			dogs.addLast((Dog)animal);
		}
	}
	
	public static Animal dequequeAny()
	{   
		Animal animal = null;
		if(cats.size() == 0)
		{
			animal=dequeueDog(); //give the head object after removal of that
		}else if(dogs.size() == 0)
		{
			animal=dequeueCat(); //give the head object after removal of that
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat))
		{
			animal=dequeueDog();
		}else if(cat.isOlderThan(dog))
		{
			animal=dequeueCat();
		}
		return animal;
	}
	
	public static Dog dequeueDog() {
		return dogs.poll();
	}
	public static Cat dequeueCat() {
		return cats.poll();
	}
}

class Animal{
	private int order;
	private String Name;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Animal(String name)
	{
		this.Name = name;
	}
	
	/*Compare the order of Animal*/
	public boolean isOlderThan(Animal animal)
	{
		return this.order < animal.order;
	}
	
}

class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}
	
}

class Cat extends Animal{

	public Cat(String name) {
		super(name);
		
	}
	
}
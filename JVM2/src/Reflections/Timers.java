package Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Timers {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
				
		int times = 10000; 
		Book b = new Book("Hobbit", "Tolkien", 1900, 500);
		
		Timers for_tests = new Timers();
		for_tests.NormalTestRead(b, times);
		for_tests.NormalTestWrite(b, times);
		for_tests.ReflectionTestRead(b, times);
		for_tests.ReflectionTestWrite(b, times);
		for_tests.InvokeMethod(b, times);
		for_tests.InvokeMethodReflection(b, times);
		
	}
			
	private void InvokeMethod(Book b, int T) {
		long startTime = System.nanoTime();
		for (int i = 0; i<=T; i++)
		   {
			  b.ChangeYOP(1990);
		   }
		long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań metody dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
	}

	private void InvokeMethodReflection(Book b, int T) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = b.getClass().getMethod("ChangeYOP", int.class);
		long startTime = System.nanoTime();
		for (int i = 0; i<=T; i++)
		   {
			  m.invoke(b, 1990);
		   }
		long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań refleksyjnych metody dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
	}

	private void ReflectionTestWrite(Book b, int T) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field fld = b.getClass().getDeclaredField("author");
		long startTime = System.nanoTime();
		   for (int i = 0; i<=T; i++)
		   {
			  fld.set(b, "Tolkien");
		   }
		   long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań refleksyjnych zapisu dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
		
	}

	private void ReflectionTestRead(Book b, int T) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field fld = b.getClass().getDeclaredField("author"); 
		long startTime = System.nanoTime();
		for (int i = 0; i<=T; i++)
		   {
			   fld.get(b);
		   }
		   long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań refleksyjnych oczytu dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
		
	}

	private void NormalTestWrite(Book b, int T) {
		long startTime = System.nanoTime();
		   for (int i = 0; i<=T; i++)
		   {
			  b.author = "Tolkien";
		   }
		   long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań normalnych zapisu dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
		
	}

	public void NormalTestRead(Book b, int T){
		String temp;
		long startTime = System.nanoTime();
		   for (int i = 0; i<=T; i++)
		   {
			   temp = b.author;
		   }
		   long estimatedTime = System.nanoTime() - startTime;
		   System.out.println(T+" wywołań normalnych oczytu dało czas: "+estimatedTime + "ns, czyli średnio "+estimatedTime/T+"ns na wywołanie");
	}
}

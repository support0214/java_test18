package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics1 {

	public static void main(String[] args) {
		// 
		// generics
		// - compile-time에 타입 제한 기능
		// - 요소 추가시에 타입 체크 기능
		// - 요소를 꺼낼때 해당 타입의 값을 보장
		// 
		// 사용하는 곳에 따라 
		// - 클래스레벨 : 변수타입이나 객체생성시 작성하여 객체요소의 타입 제한
		// - 메서드레벨 : 파라미터/리턴타입에 타입제한
		
		// boxing(auto-boxing) : int -> Integer.valueOf(1) 
		// unboxing : 객체형태로 들어온(Integer) => int
		ArrayList<String> list = new ArrayList<>();
		list.add("안녕");
		list.add("잘가");
		list.add("내일봐");
		// list.add(123); 오류

		// String str = (String) list.get(0); 제네릭을 명시하지 않았을 경우 반드시 형변환(Object -> String)
		String str = list.get(0);
		// int num = (int)list.get(1); 오류
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		int num = list2.get(1);
		

		
		test1();
		test2();
		
		
		
	}

	// 클래스 레벨의 제네릭
	public static void test1() {
		Parking<String> strPark = new Parking<>();
		strPark.add("SM7");
		strPark.add("GENESIS");
		
		System.out.println(strPark.get(0));
		System.out.println(strPark.get(1));
		System.out.println("------------");
		
		for(int i=0; i<strPark.size(); i++) {
			System.out.println(strPark.get(i));
		}
		System.out.println("------------");
		
		System.out.println(strPark.indexOf("SM7"));
		System.out.println(strPark.indexOf("GENESIS"));
		System.out.println(strPark.indexOf("ㅋㅋㅋ"));	
	}
	
	public static void test2() {
		int num1 = run(10);
		int num2 = run(20);
		String str = run("abc");
		
		System.out.println(num1+num2);
		System.out.println(str+num1+num2);
		
		List<Integer> list = of(1,3,5,7,9);
		System.out.println(list);
		
		List<String> strList = of("5교시", "졸려요", "제네릭", "어려워요");
		System.out.println(strList);
		
		// 자바에서 Array을 List 변환해주는 메서드 Arrays.asList(array) 사용
		// JDK 9버전부터 List.of(array)라는 새로운 팩토리 메서드 사용
		
		// Arrays.asList, List.of : 변경불가 list임. 삽입, 삭제 불가 
		List<String> strList2 = List.of("자요", "졸면안되요");
		System.out.println(strList2);
		strList2.add("말똥말똥");
	}
	
	public static <T> T run(T t) {
		return t;
	}
	
	public static <E> List<E> of(E... elems){
		List<E> list = new ArrayList<>();
		
		for(E e : elems) {
			list.add(e);
		}
		return list;
	}
}

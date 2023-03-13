package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Map1 {

	public static void main(String[] args) {
		HashMap<String, Snack> hm = new HashMap();
		
		// 계층구조
		// List계열, Set계열은 Collection 구현한 클래스
		// => 객체를 추가할 때 add()메서드 사용
		
		// map계열은 Collection 상속받아서 구현한 쿨래스가 아니다
		// => 추가하고자 할때 put() 메서드 이용 (이때, key+value 세트로 담아야됨)
		
		// 1. put(k key, v value)
		hm.put("다이제스트", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("고소한맛", 400));
		hm.put("포테이토칩", new Snack("짠맛", 500));
		System.out.println(hm);
		
		// key 값은 중복을 허용하지 않는다 : 같은 키가 들어오면 덮어쓰기가 됨
		// 값은 허용 
		hm.put("새우깡", new Snack("달콤한맛", 500));
		System.out.println(hm);
		
		hm.put("버터쿠키", new Snack("짠맛", 500));
		System.out.println(hm);
		
		// 2. get(Object key) : 해당 키 값의 value응 반환시켜주는 메서드
		// Object value = hm.get("다이제스트");
		Snack s = (Snack) hm.get("다이제스트"); // 형변환
		// Snack s = hm.get("다이제스트"); (Snack) 생략가능 객체생성할때 제네릭을 설정했기때문
		System.out.println(s);
		
		// 3. size() : 담겨져 있는 객체의 갯수 반환
		System.out.println("객체의 수 : " + hm.size());
		
		// 4. replace(K key, V value) => 해당 키를 찾아서 value값을 변경 해줌
		hm.replace("포테이토칩", new Snack("겁나짠맛", 700));
		System.out.println(hm);
		
		// map안의 모든 키값과 value값을 출력하고자 할 때
		// for( : hm ) 사용 X
		
		// Iterator 반복자를 이용 => List, Set에서만 사용하는 메서드
		// Iterator it = ((Object) hm).iterator();
		
		// Map을 Set으로 바꿔주는 메서드를 제공(2개)
		// 1. keySet()을 이용하는 방법
			// Map -> Set -> Iterator
		
			// 1) hm에 있는 키들만 Set에 담기(키들의 집합 형태)
			// hm.keySet() -> Set으로 변경
		Set<String> keySet = hm.keySet();
		
			// 2) ketSet을 Iterator에 담기
		Iterator<String> itkey = keySet.iterator();
		
			// 3) 반복문을 이용하여 값 얻어오기
		while(itkey.hasNext()) {
			String key = (String) itkey.next();
			Snack value = (Snack) hm.get(key);
			System.out.println(key + " = " + value);
		}
		System.out.println("=================================");
		
		// 2. entrySet()을 이용하는 방법
			// 1) hm.entrySet() : 키 + 값
		Set<Entry<String, Snack>> entrySet = hm.entrySet();
		
			// 2) entrySet.iterator() : 담기
		Iterator<Entry<String, Snack>> itEntry = entrySet.iterator();
		
			// 3) 반복문을 통해 가져오기
		while(itEntry.hasNext()) {
			Entry<String, Snack> entry = /* (Entry) */ itEntry.next();
			String key = /*(String)*/ entry.getKey();
			Snack value =/*(Snack)*/ entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}

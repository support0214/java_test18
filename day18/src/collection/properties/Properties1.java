package collection.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties1 {

	public static void main(String[] args) {
		// properties : Map계열 컬렉션 => key + value 세트로 저장
		// HashMap과의 차이점 : properties는 키값도 String, value값도 String 이어야 됨
		
		Properties prop = new Properties();
//		
//		// Map계열이기 때문에 put메서드로 키 + 값 세트 담기 가능
//		prop.put("다이제스트", new Snack("초코맛", 1500));
//		prop.put("새우깡", new Snack("짠맛", 800));
//		System.out.println(prop);
//		System.out.println(prop.get("새우깡"));
//		
//		// properties를 사용하는 경우는 주로 파일로 출력 또는 입력을 받아 올 때 사용함 
//		// 즉, store(), load() 메서드를 사용
//		
//		// 파일로 내보내기
//		try {
//			prop.store(new FileOutputStream("test.properties"), "propertiesTest");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// properties를 파일로 내보내기를 하려면 String, String 이어야 한다
		// 1. setProperties(String key, String value)
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMet");
		prop.setProperty("Map", "Properties");
		System.out.println(prop);
		
		// 2. getProperties(String key)
		System.out.println(prop.getProperty("List"));
		System.out.println(prop.getProperty("A"));
		
		try {
			// properties 파일로 출력
		prop.store(new FileOutputStream("test.properties"), "propertiesTest");
			
			// storeToXML
			prop.storeToXML(new FileOutputStream("text.xml"), "propertiesTest");
			
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

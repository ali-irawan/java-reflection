package id.co.solusiteknologi.java.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainApp {

	public static String formatModifier(int modifier){
//		public static final int	ABSTRACT	1024
//		public static final int	FINAL	16
//		public static final int	INTERFACE	512
//		public static final int	NATIVE	256
//		public static final int	PRIVATE	2
//		public static final int	PROTECTED	4
//		public static final int	PUBLIC	1
//		public static final int	STATIC	8
//		public static final int	STRICT	2048
//		public static final int	SYNCHRONIZED	32
//		public static final int	TRANSIENT	128
//		public static final int	VOLATILE	64
		StringBuilder strModifier = new StringBuilder();
		
		if((modifier & Modifier.PUBLIC) == Modifier.PUBLIC) strModifier.append("public ");
		if((modifier & Modifier.PROTECTED) == Modifier.PROTECTED) strModifier.append("protected ");
		if((modifier & Modifier.PRIVATE) == Modifier.PRIVATE) strModifier.append("private ");
		if((modifier & Modifier.SYNCHRONIZED) == Modifier.SYNCHRONIZED) strModifier.append("synchronized ");
		if((modifier & Modifier.FINAL) == Modifier.FINAL) strModifier.append("final ");
		if((modifier & Modifier.STATIC) == Modifier.STATIC) strModifier.append("static ");
		return "";
	}
	public static void main(String[] args) {
		
		// Using reflection get all method from String
		
		Class clazz = String.class;

		Method[] methods = clazz.getDeclaredMethods();
		if(methods!=null){
			for(Method method : methods){
				int modifier = method.getModifiers();
				Class returnType = method.getReturnType();
				String methodName = method.getName();
				Class[] params = method.getParameterTypes();
				
				http://docs.oracle.com/javase/7/docs/api/constant-values.html#java.lang.reflect.Modifier.ABSTRACT
					
				System.out.println(formatModifier(modifier));
				System.out.print(returnType.getSimpleName() + " " + method.getName() + "(");
				int i=0;
				for(i=0;i<params.length;i++){
					System.out.print(params[i].getName());
					if(i<params.length-1) System.out.print(",");
				}
				System.out.println(")");
			}
		}
	}

}

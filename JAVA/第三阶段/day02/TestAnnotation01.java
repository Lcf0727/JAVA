package com.cy.java.oop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Target注解用于定义我们自己定义的注解可以描述哪些成员.
 * @Retention 注解用于描述注解何时有效(我们自己定义的注解都写运行时有效)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component{}//注解(Spring框架写)

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service{}//注解(Spring框架写)

/**
 * Spring 框架中如何知道这个类上是否有特定注解描述
 */
@Component
class DefaultCache{}//我们自己写

public class TestAnnotation01 {
	//由spring框架写
	private static Class[] array= {
			Component.class,Service.class
	};
	//判定targetCls上是否有指定的注解描述
	//由spring框架写
	static boolean isAnnotationPresent(Class<?> targetCls) {
		for(Class annotation:array) {
			boolean flag=
		    targetCls.isAnnotationPresent(annotation);
			if(flag)return true;
		}
		return false;
	}
	public static void main(String[] args) {
		//1.获取类的字节码对象
		Class<?> c1=DefaultCache.class;//Spring框架来写
		//2.判定DefaultCache类上是否有@Component注解
		//boolean flag=c1.isAnnotationPresent(Component.class);
		//System.out.println(flag);
		boolean flag=isAnnotationPresent(c1);//Spring框架判断
		System.out.println("flag="+flag);
		
	}
}







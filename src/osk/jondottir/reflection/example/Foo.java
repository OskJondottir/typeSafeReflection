package osk.jondottir.reflection.example;

import static osk.jondottir.reflection.Inspector.inspect;
import static osk.jondottir.reflection.Inspector.method;

import java.lang.reflect.Method;

public class Foo {
    private String a;
    private int b;
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        //Two possible usages: passing an instance in...
        Foo foo = new Foo();
        Method methodGetA = method(inspect(foo).getA());

        //...or passing the class in
        Method methodGetB = method(inspect(Foo.class).getB());

        System.out.println(methodGetA.getName()); //displays "getA"
        System.out.println(methodGetB.getName()); //displays "getB"
        
        //Method methodGetBar = method(inspect(foo).getBar());  //This gives a compile time error: the method name must exist!
    }
    
}

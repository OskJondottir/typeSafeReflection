# typeSafeReflection

A tiny library to provide method reflection with compiler checks for Java.

## Usage

Two possible usages: passing an instance in...

    Foo foo = new Foo();
    Method methodGetA = method(inspect(foo).getA());

...or passing the class in

    Method methodGetB = method(inspect(Foo.class).getB());

If the method name does not exist, there will be a compile-time error:

    public class Foo {
        private String a;
        private int b;
        public String getA() { return a; }
        public int getB() { return b; }
    }
    
    //This gives a compile time error: the method name must exist!
    Method methodGetBar = method(inspect(foo).getBar()); 

Standard reflection, however, will only give us a runtime error if the method name does not exist in the class:

    //This will compile, however, but then throw NoSuchMethodException during execution
    Method methodGetBar = Foo.class.getMethod("getBar"); 

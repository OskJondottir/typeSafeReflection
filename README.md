# typeSafeReflection

A tiny library to provide method reflection with compiler checks for Java.

## Usage

Two possible usages: passing an instance in...

    Foo foo = new Foo();
    Method methodGetA = method(inspect(foo).getA());

...or passing the class in

    Method methodGetB = method(inspect(Foo.class).getB());

If the method name does not exist, there will be a compile-time error:

    Method methodGetBar = method(inspect(foo).getBar()); //This gives a compile time error: the method name must exist!

Standard reflection, however, will only give us a runtime error if the method name does not exist in the class:

    Method methodGetBar = Foo.class.getMethod("getBar"); //This will compile, though, then throw NoSuchMethodException during execution

Tyler Waltze

7/5/15

MET CS 342

Homework 1

**1)** Define the following terms (10 points each):
1. _protected_ A class method or attribute that is accessible to only itself and classes that inherit from it or are within the same package.

2. _static_ A method or attribute that belongs to the general class, not specific instances of the class.

3. _implements_ A keyword for a class to indicate its using of an interface.

4. _interface_ A set of fields and method headers with no implementation. implementation is handled by a class that implements the interface. Cannot be instantiated.

5. _abstract_ A keyword indicating either the specific method (if used on a method) will have no implementation, or the member methods (if used on a class) may not have any implementation. Cannot be instantiated.

**2)** Define the order of the growth functions using big-O notation. List them from the most efficient to least efficient (10 points):

1. 10n2 + 100n + 1000 => n^2

2. 10n3 – 7 => n^3 _(tied with 3)_

3. 2n + 100n3 => n^3 _(tied with 2)_

4. 0.2n4 => n^4

**3)** UML is language specific. True or false? (10 points): False

**4)** How are abstract classes and interfaces the same? (15 points):

Neither can be instantiated and both allow for methods without an implementation.

**5)** How are abstract classes and interfaces different? (15 points):

Interfaces are not allowed to have **any** implemented methods, while an abstract class is allowed. Other classes implement an interface, while they extend an abstract class. Other classes can only extend one abstract class, but can implement an unlimited number of interfaces. Abstract classes can have instanced fields.

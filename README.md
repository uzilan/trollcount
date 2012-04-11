Trollcount
===========

Trollcount is a simple scala library which simulates the [troll] numeral system[*] according to the [Discworld]. It allows it's users to create troll numbers and to add them to each other. Here's an example:

```scala
scala> import se.diversify.trollcount.TrollNumber._
import se.diversify.trollcount.TrollNumber._

scala> val one = One
one: se.diversify.trollcount.TrollNumber = One

scala> val three = Three
three: se.diversify.trollcount.TrollNumber = Three

scala> three.value
res0: Int = 3

scala> val five = Many-One
five: se.diversify.trollcount.TrollNumber = Many-One

scala> val ten = five + five
ten: se.diversify.trollcount.TrollNumber = Many-Many-Two

scala> val fourteen = Many-Many-One + Many-One
fourteen: se.diversify.trollcount.TrollNumber = Many-Many-Many-Two

scala> fourteen.value
res1: Int = 14
```

This library exists in three branches:
 
 * **master** - *The complete library.* Use this branch if you want to see my implementation.
 * **tests-only** - *Only contains tests and no implementation.* Use if this branch if you want to implement 
the whole library logic on your own.
 * **tests-and-stubs** - *Contains stub implementations and failing tests.* Use this branch if you want to 
bootstrap your implementation and add the missing bits.

To get the code, run:
    
    git clone git://github.com/uzilan/trollcount.git

To switch to a different branch, run:
    
    git checkout master
or...
    
    git checkout tests-only
or...
    
    git checkout tests-and-stubs
[*] the [troll] numeral system goes like this:
    
```
One, Two, Three, Many,
Many-One, Many-Two, Many-Three, Many-Many,
Many-Many-One, Many-Many-Two, Many-Many-Three, Many-Many-Many,
Many-Many-Many-One, Many-Many-Many-Two, Many-Many-Many-Three, Lots
```

[troll]: http://en.wikipedia.org/wiki/Troll_(Discworld)
[Discworld]: http://en.wikipedia.org/wiki/Discworld
package se.diversify

/** According to the [[http://en.wikipedia.org/wiki/Discworld Diskworld]], the
  * [[http://en.wikipedia.org/wiki/Troll_(Discworld) Trolls]] have a very special numeric system, which can be
  * visualised as:
  * {{{
  * One (1),  Two (2), Three (3), Many (4),
  * Many-One (5), Many-Two (6), Many-Three (7), Many-Many (8),
  * Many-Many-One (9), Many-Many-Two (10), Many-Many-Three (11), Many-Many-Many (12),
  * Many-Many-Many-One (13), Many-Many-Many-Two(14), Many-Many-Many-Three (15), Lots (16)
  * }}}
  *
  * Using the [[se.diversify.trollcount.TrollNumber]] class allows users to create troll numbers, as well as adding them to each other. For example:
  * {{{
  * val two = Two
  * val five = Many-One
  * val fourteen = five + Many-Many-One
  * }}}
  */
package object trollcount {}

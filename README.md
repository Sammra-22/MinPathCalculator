# Minimal path calculator

A scala app that computes the minimal path in a triangle of numbers. 

```
7
6 3
3 8 5
11 2 10 9
```

A path through the triangle is a sequence of adjacent nodes, one from each row, starting from the top.

A minimal path is defined as one whose sum of values in its nodes is no greater than for any other path through the triangle.

In the above example the minimal path is: 7 + 6 + 3 + 2 = 18

### Requirements
- SBT 1.2.1+
- Scala 2.12.6+
- Java Runtime 1.8+

### Build

Using scala interpreter:
```
> sbt compile
> sbt package
> cat << EOF | scala MinimalPathCalculator-0.1.jar

```

Using java interpreter:
```
> sbt compile
> sbt assembly
> cat << EOF | java -jar MinimalPathCalculator-assembly-0.1.jar

```

###

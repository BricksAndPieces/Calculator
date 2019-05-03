# Calculator
A simple calculator made in Java thats parses a String input and returns a double.

Created by BricksAndPieces


**Features**
- Fully text based, no need for a UI
- Supports power, parentheses, and order of operations
- Based around one method that will repeatedly call itself to fully parse the equation


**How it works**
This calculator follows all math rules such as the Order of Operations (PEMDAS).

`P` - Parentheses

`E` - Exponents

`M` - Multiplication

`D` - Divison

`A` - Addition

`S` - Subtraction

Along with this idea, the calculator also supports power, roots (soon), and some other smaller features.


The calculator is heavily built around the idea of recursion. It is used to parse the equation that is inputted as a String into a double output. The first step in parsing the String is to look for any parentheses and format according to them. In this case, we are just parsing items withing the parentheses first before moving on with the rest of the equation.

```java
final int end = s.indexOf(")");
if(end != -1) {
final int start = s.substring(0, end).lastIndexOf("(");
if(start == -1)
  throw new IllegalArgumentException("Parentheses do not match");

return parse(s.substring(0, start) + parse(s.substring(start+1, end)) + s.substring(end+1));
```

`Please note that this is within a method called parse() with a String parameter "s" that represents the equation`

We then need to parse the actual equation after all the parentheses are taken care of. This is relatively simple and just means we need to look for the operator signs (+, - , \*, /, ^) and parse accordingly. We go backwards in PEMDAS because we start at the outside and work our way in. That way, when we finally reach the end of the recursion, we start with the power, the the division, and so on.

```java
if(s.contains(ADD)) {
  final int index = s.indexOf(ADD);
  return parse(s.substring(0, index)) + parse(s.substring(index+1));
}else if(s.contains(SUBTRACT)) {
  final int index = s.indexOf(SUBTRACT);
  return parse(s.substring(0, index)) - parse(s.substring(index+1));
}else if(s.contains(MULTIPLY)) {
  final int index = s.indexOf(MULTIPLY);
  return parse(s.substring(0, index)) * parse(s.substring(index+1));
}else if(s.contains(DIVIDE)) {
  final int index = s.indexOf(DIVIDE);
  return parse(s.substring(0, index)) / parse(s.substring(index+1));
}else if(s.contains(POWER)) {
  final int index = s.indexOf(POWER);
  return Math.pow(parse(s.substring(0, index)), parse(s.substring(index+1)));
}
```

`Please note that this is within a method called parse() with a String parameter "s" that represents the equation`

That is all that is needed to successfully parse the String. All that is left to do is return the double if there are no operators left and if its a valid equation. This can be done easily with `Double.parseDouble(s);`.

This is just how the calculator works in concept. Feel free to clone this project locally to try it out yourself! More information on how the code works along with the entire `Calculator` class can be found (here)[https://github.com/BricksAndPieces/Calculator/blob/master/src/Calculator.java].

**Issues**
Find any issues? Feel free to suggest a change and/or report a bug!

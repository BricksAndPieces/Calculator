public class Calculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String POWER = "^";

    public double calculate(final String equation) {
        return parse(equation.replaceAll(" ", ""));
    }

    private double parse(final String s) {
        try { return Double.parseDouble(s); }
        catch(final NumberFormatException e) {
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
        }

        throw new IllegalArgumentException("Invalid input");
    }
}
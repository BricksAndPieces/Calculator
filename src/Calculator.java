public class Calculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String POWER = "^";

    public double calculate(final String equation) {
        return parse(equation.replaceAll("//s+", ""));
    }

    private double parse(final String s) {
        final int end = s.indexOf(")");
        if(end != -1) {
            final int start = s.substring(0, end).lastIndexOf("(");
            if(start == -1)
                throw new IllegalArgumentException("Parentheses do not match");

            return parse(s.substring(0, start) + parse(s.substring(start+1, end)) + s.substring(end+1));
        }

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
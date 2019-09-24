public class Calculator {

    private Calculator() { }

    public static double solve(final String equation) {
        return parse(equation.replaceAll("//s+", ""));
    }

    private static double parse(final String s) {
        final int end = s.indexOf(")");
        if(end != -1) {
            final int start = s.substring(0, end).lastIndexOf("(");
            if(start == -1)
                throw new IllegalArgumentException("Invalid input");

            return parse(s.substring(0, start) + parse(s.substring(start+1, end)) + s.substring(end+1));
        }

        final int absolute = s.lastIndexOf("|");
        if(absolute != -1) {
            final int start = s.indexOf("|");
            if(start == absolute)
                throw new IllegalArgumentException("Invalid input");

            return parse(s.substring(0, start) + Math.abs(parse(s.substring(start+1, absolute))) + s.substring(absolute+1));
        }

        try { return Double.parseDouble(s); }
        catch(final NumberFormatException e) {
            if(s.contains(Operator.ADD)) {
                final int index = s.indexOf(Operator.ADD);
                return parse(s.substring(0, index)) + parse(s.substring(index+1));
            }else if(s.contains(Operator.SUBTRACT)) {
                final int index = s.indexOf(Operator.SUBTRACT);
                return parse(s.substring(0, index)) - parse(s.substring(index+1));
            }else if(s.contains(Operator.MULTIPLY)) {
                final int index = s.indexOf(Operator.MULTIPLY);
                return parse(s.substring(0, index)) * parse(s.substring(index+1));
            }else if(s.contains(Operator.DIVIDE)) {
                final int index = s.indexOf(Operator.DIVIDE);
                return parse(s.substring(0, index)) / parse(s.substring(index+1));
            }else if(s.contains(Operator.POWER)) {
                final int index = s.indexOf(Operator.POWER);
                return Math.pow(parse(s.substring(0, index)), parse(s.substring(index+1)));
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }
}
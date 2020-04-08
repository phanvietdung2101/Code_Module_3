package Model;

public class Calculator {
    public double calculate(double num1, double num2, String operator) throws NumberFormatException{
        double result = -1;
        if(operator.equals("+"))
            result =  num1 + num2;
        else if(operator.equals("-"))
            result = num1 - num2;
        else if(operator.equals("*"))
            result = num1 * num2;
        else if(operator.equals("/")){
            if(num2 == 0) {
                throw new NumberFormatException();
            } else
                result = num1 / num2;
        }
        return result;
    }
}

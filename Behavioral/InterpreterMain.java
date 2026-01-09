package Behavioral;

abstract class Expression {
    public abstract int interpret();
}
class NumberInterpreter extends Expression {
    private int number;

    public NumberInterpreter(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
 class AddExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public AddExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}
 class subExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public subExpression(Expression left, Expression right) {
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
 }
   
public class InterpreterMain {
    public static void main(String[] args) {
        Expression five = new NumberInterpreter(5);
        Expression three = new NumberInterpreter(3);
        Expression two = new NumberInterpreter(2);

        Expression addition = new AddExpression(five, three);
        Expression subExpression = new subExpression(addition, two);
        System.out.println("Result: " + subExpression.interpret());
    }
}

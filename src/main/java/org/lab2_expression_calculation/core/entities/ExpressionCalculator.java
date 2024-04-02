package org.lab2_expression_calculation.core.entities;

import java.util.*;

/**
 * Expression calculator that evaluates mathematical expressions containing variables.
 */
public class ExpressionCalculator {
    boolean hasOperator=false;
    private final Map<String, Double> variables;

    /**
     * Gets the map of variables and their corresponding values.
     *
     * @return The map of variables and their values.
     */
    public Map<String, Double> getVariables() {
        return variables;
    }

    /**
     * Constructs an ExpressionCalculator with an empty variable map.
     */
    public ExpressionCalculator() {
        this.variables = new HashMap<>();
    }

    /**
     * Adds a variable with its corresponding value to the calculator.
     *
     * @param variableName The name of the variable.
     * @param value        The value of the variable.
     */
    public void addVariable(String variableName, double value) {
        variables.put(variableName, value);
    }

    /**
     * Evaluates the given expression with the current variables' values.
     *
     * @param expression The mathematical expression to be evaluated.
     * @return The result of the evaluation.
     */
    public double evaluateExpression(String expression) {
        for (Map.Entry<String, Double> entry : variables.entrySet()) {
            expression = expression.replaceAll(entry.getKey(), Double.toString(entry.getValue()));
        }

        return evaluate(expression);
    }

    /**
     * Provides an example mathematical expression with variables for reference.
     *
     * @return An example mathematical expression with variables.
     */
    public String giveExample(){
        return "sin(x)+cos(x)+tan(y)-asin(x)-ctan(y) + x^3 - y*x / sqrt(y)";
    }

    /**
     * Evaluates the given mathematical expression and returns the result.
     * This method parses the expression and computes its value using the parseExpression method.
     *
     * @param expression The mathematical expression to be evaluated.
     * @return The result of evaluating the mathematical expression.
     */
    private double evaluate(String expression) {
        return new Object() {
            int pos = -1, ch;

            /**
             * Moves the current character pointer to the next character in the expression.
             */
            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            /**
             * Consumes the specified character from the expression.
             *
             * @param charToEat The character to consume.
             * @return True if the character was consumed, false otherwise.
             */
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            /**
             * Parses the expression and evaluates it.
             *
             * @return The result of the expression evaluation.
             */
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            /**
             * Parses the expression for addition and subtraction operations.
             *
             * @return The result of the addition and subtraction operations.
             */
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        if (hasOperator) {
                            throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                        }
                        hasOperator = true;
                        x += parseTerm();
                    } else if (eat('-')) {
                        if (hasOperator) {
                            throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                        }
                        hasOperator = true;
                        x -= parseTerm();
                    } else {
                        hasOperator = false;
                        return x;
                    }
                }
            }

            /**
             * Parses the expression for multiplication and division operations.
             *
             * @return The result of the multiplication and division operations.
             */
            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) {
                        if (hasOperator) {
                            throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                        }
                        hasOperator = true;
                        x *= parseFactor();
                    } else if (eat('/')) {
                        if (hasOperator) {
                            throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                        }
                        hasOperator = true;
                        x /= parseFactor();
                    } else {
                        hasOperator = false;
                        return x;
                    }
                }
            }

            /**
             * Parses the expression for factors, including unary operators, parentheses, numbers, and functions.
             *
             * @return The result of the factor evaluation.
             */
            double parseFactor() {
                if (eat('+')){
                    if (hasOperator) {
                        throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                    }
                    hasOperator = true;
                    return parseFactor();
                }
                if (eat('-')){
                    if (hasOperator) {
                        throw new RuntimeException("Unexpected operator after another operator at position " + pos);
                    }
                    hasOperator = true;
                    return -parseFactor();
                }

                double x;
                boolean prevhasOperator = hasOperator;
                int startPos = this.pos;
                if (eat('(')) {
                    hasOperator = false;
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Expected closing parenthesis at position " + pos);
                    else hasOperator = prevhasOperator;
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = expression.substring(startPos, this.pos);
                    if (!eat('(')) throw new RuntimeException("Expected opening parenthesis after function at position " + startPos);
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Expected closing parenthesis after function argument at position " + pos);
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        case "ctan":
                            x = 1.0 / Math.tan(Math.toRadians(x));
                            break;
                        case "asin":
                            x = Math.asin(Math.toRadians(x));
                            break;
                        case "acos":
                            x = Math.acos(Math.toRadians(x));
                            break;
                        case "atan":
                            x = Math.atan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                hasOperator = false;
                return x;

            }

        }.parse();
    }
}


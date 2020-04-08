import Model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/index")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("first_operand"));
        double num2 = Double.parseDouble(request.getParameter("second_operand"));
        String operator = request.getParameter("operator");

        Calculator calculator = new Calculator();
        RequestDispatcher dispatcher;
        try {
            double result = calculator.calculate(num1, num2, operator);
            request.setAttribute("result", result);
            dispatcher = request.getRequestDispatcher("calculator.jsp");
        } catch (NumberFormatException e){
            dispatcher = request.getRequestDispatcher("error.jsp");
        }

        dispatcher.forward(request,response);
    }
}

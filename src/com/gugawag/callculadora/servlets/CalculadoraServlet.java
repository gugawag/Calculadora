package com.gugawag.callculadora.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet.
 */
@WebServlet("/calcular.do")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraServlet() {
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("Servlet iniciado");
    }
    
    @Override
    public void destroy() {
    
    	super.destroy();
    	System.out.println("Servlet destru’do");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("oper");
		int numero1 = Integer.parseInt(request.getParameter("num1"));
		int numero2 = Integer.parseInt(request.getParameter("num2"));
		
		
		int resultado = 0;
		switch(operacao.charAt(0)){
			case 'm': {
				resultado = numero1 + numero2;
				break;
			}
			case '-': {
				resultado = numero1 - numero2;
				break;
			}
			case '*': {
				resultado = numero1 * numero2;
				break;
			}
			case '/': {
				resultado = numero1 / numero2;
				break;
			}
			
		}
		
		response.setContentType("text/plain");
		PrintWriter saida = response.getWriter();
		saida.write("Resultado: " + resultado);
		saida.close();
		
	}

}

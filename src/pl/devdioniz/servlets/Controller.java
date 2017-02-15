package pl.devdioniz.servlets;

import java.io.IOException;

import java.util.logging.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	private static final Logger LOG = Logger.getAnonymousLogger();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		
		ServletContext ctx = getServletContext();

		String action = request.getParameter("action");
		
		if (action == null || action.isEmpty()) {
			LOG.info("Action paramerer is null, forwarding to home page.");
			ctx.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			return;
		}
		
		System.out.println("Action param: " + action);
		LOG.info("Action param is: " + action);

		switch (action) {

		case "home":
			ctx.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			break;
		case "add":
			ctx.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);
			break;
		case "list":
			ctx.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
			break;
		default:
			ctx.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

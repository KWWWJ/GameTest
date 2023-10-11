package WhiteCatLucyServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import whiteCatLucy.script.SystemScript;

/**
 * Servlet implementation class Intro
 */
@WebServlet("/intro")
public class Intro extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 2685444196136033448L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Intro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SystemScript script = new SystemScript();
		String box = null;
		
		script.intro();
		
		List<String> nowScript = script.script;
		response.setContentType("text/html;charset=utf-8");
		
		for (int i = 0; i < nowScript.size(); i++) {
			response.getWriter().append(nowScript.get(i));
		}
		request.setAttribute(box, nowScript);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

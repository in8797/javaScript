package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class EmpListServ
 */
@WebServlet("/EmpListServ")
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpListServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// { "data": [
		// [firstName, lastName, salary, hireDate, email, jobId],[],[]
		// ]
		// } obj 안에 배
		
		JSONArray inAry = new JSONArray();
		JSONArray outAry = new JSONArray();
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getJsondata();
		for (Employee emp : list) {
			inAry = new JSONArray();
			inAry.add(emp.getFirstName());
			inAry.add(emp.getLastName());
			inAry.add(emp.getSalary());
			inAry.add(emp.getHireDate());
			inAry.add(emp.getEmail());
			inAry.add(emp.getJobId());
			outAry.add(inAry);
		}
		JSONObject obj = new JSONObject();
		obj.put("data", outAry);
		PrintWriter out = response.getWriter(); //화면에 출력할시.
		out.println(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

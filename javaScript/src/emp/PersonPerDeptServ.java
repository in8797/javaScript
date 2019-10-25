package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class PersonPerDeptServ
 */
@WebServlet("/PersonPerDeptServ")
public class PersonPerDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonPerDeptServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONArray ary = new JSONArray();
		JSONObject obj = new JSONObject();
		EmpDAO dao = new EmpDAO();
		Map<String, Integer> list = dao.getPersonPerDept();
		Set<Map.Entry<String, Integer>> mapSet = list.entrySet();
		for (Map.Entry<String, Integer> map : mapSet) {
			System.out.println(map.getKey() + map.getValue()); // 부서명 , 인원

			obj = new JSONObject();
			obj.put("name", map.getKey());
			obj.put("data", map.getValue());
//			obj.put("name:" + map.getKey(), "data:" + map.getValue());
			ary.add(obj);
		}
		PrintWriter out = response.getWriter(); // 화면에 출력할시.
		out.println(ary);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

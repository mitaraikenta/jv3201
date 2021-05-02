package BMI;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMIServlet
 */
@WebServlet("/BMIServlet")
public class BMIServlet extends HttpServlet {
	//定数
	private static final long serialVersionUID = 1L;
	//マジックナンバーを使い条件式の定数を書いていく
	//最終的にconstクラスとか作ってほしいな
	//修飾子　static:静的 最終的に
	//アクションによって値が変わるのは動的
	public static final double skinyy_type = 18.5;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMIServlet() {
    	//スーパー関数
    	super();


        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //doGet doPostオーバーライドにしている
    //強制操縦

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字化け対策
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html: charset=utf-8");
		//input type のnameの所
		String strheight = request.getParameter("height");

		String strweight = request.getParameter("weight");

		RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");

		Double height = 0.0;
		Double weight = 0.0;


		// doubleは基本型なのでDouble
		//クラスのはメソッド 機能がある
		//クラスは小文字からは始めない

		//RoundingMode.HALF_UPは四捨五入、HALF_DOWN

		//trycatchは必須

		try {
			height = Double.parseDouble(strheight);
			weight = Double.parseDouble(strweight);
		} catch (NumberFormatException e) {
			System.out.print(e.getStackTrace());
			request.setAttribute("MSG","数値が入力されています");
			rd.forward(request, response);
			return;
		}



		Double height10  = height / 100;

		String body = "";

		Double BMI = 0.0;







		BMI =  weight / (height10 * height10);

		if(BMI<skinyy_type) {
			body = "やせ型";
		}

		if(18.5<BMI && 25>BMI) {
			body = "普通";
		}

		if(BMI>25) {
			body = "肥満";
		}




		//チェックボックスの場合は文字列型の配列で受け取る



		request.setAttribute("height",height);//文字列
		request.setAttribute("weight",weight);//文字列
		request.setAttribute("BMI",BMI);//文字列
		request.setAttribute("BODY",body);//文字列







		rd = request.getRequestDispatcher("/output.jsp");


		//forwardはjspを読み込んでいる
		rd.forward(request,response);





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dopostに飛んで来たらそのままdogetに飛ぶので
		//メインの処理はdoPostに書く
		doGet(request, response);
	}

}

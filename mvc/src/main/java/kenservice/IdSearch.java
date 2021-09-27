package kenservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kendao.EmpDao;
import kenmodel.EmpBean;

public class IdSearch {

	public void execute(HttpServletRequest request) throws Exception {
		EmpDao daoTest = null;
		String empId = request.getParameter("paramId");

		try {
			if (empId != null && !empId.isEmpty()) {
				daoTest = new EmpDao();
				EmpBean empBean = daoTest.getEmpDataById(Integer.parseInt(empId));

				if (empBean != null) {
					ArrayList<EmpBean> empList = new ArrayList<>();
					empList.add(empBean);
					request.setAttribute("empList", empList);

				} else {
					request.setAttribute("message", "該当者はいません");

				}

			} else {
				request.setAttribute("message", "検索IDを入力してください");

			}
		} finally {
			if( daoTest != null ) {
				daoTest.close();	//DBをクローズする
			}
		}

	}

}

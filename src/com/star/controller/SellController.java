package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Sell;
import com.star.mapper.CustomMapper;
import com.star.mapper.SellMapper;



@Controller
public class SellController {
	@Autowired
	private SellMapper sm;
	@Autowired
	private CustomMapper cm;
	
	@RequestMapping("/SellList")
	public String findAllSell(HttpServletRequest request) {
		List<Sell> listsl = sm.findAll();
		request.setAttribute("list", listsl);
		return "/sellList";
	}
	@RequestMapping("/SellModify")
	public String SellModify(HttpServletRequest request) {
		// 获取参数值
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		// 获取判断语句name的值
		String act = request.getParameter("act");
		
		// 测试初始值
		/* System.out.println("初始act:" + act);
		System.out.println("初始Id:" + id);
		System.out.println("flag:" + flag);  */
		
		// 查询销售信息

		List<Custom> list = cm.selectCustomByType(1);
		// 保存
		request.setAttribute("provider", list);
		// 删除
		if (flag != null) {
			//调用根据id删除的方法
			sm.deleteSell(id);
			//转发
			return "redirect:/SellList";
		}
		
		//判断(是点击的保存还是其他)
		if (act == null) {
			
			if (id == null) {
				// 添加
			} else {
				// 修改
				Sell s = sm.findById(id);
				request.setAttribute("sell", s);
			}
			//转发到编辑界面
			return "sellForm";
		} else {
			
			// 获取保存时传递的数据
			String sid = request.getParameter("sid");
			String cid = request.getParameter("cid");
			String date = request.getParameter("date");
			double totalprice = Double.parseDouble(request.getParameter("totalprice"));
			String buyer = request.getParameter("buyer");
			// 实例化Stock
			Sell s = new Sell();
			s.setSid(sid);
			// 实例化custom
			Custom ce = new Custom();
			ce.setCid(cid);
			s.setCustom(ce);
			s.setDate(date);
			s.setTotalprice(totalprice);
			s.setBuyer(buyer);
			
			//保存 添加
			if ("add".equals(act)) {
				//调用添加的方法
				sm.insert(s);

			} else if ("mdy".equals(act)) {
				//调用修改的方法
				sm.updateSell(s);
			}
			
			//转发到查询所有销售信息的地址
			return "redirect:/SellList";
		}		
	}
}


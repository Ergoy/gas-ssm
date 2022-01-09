package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Sell;
import com.star.entity.ToCustom;
import com.star.mapper.CustomMapper;
import com.star.mapper.SellMapper;
import com.star.mapper.ToCustomMapper;



@Controller
public class ToCustomController {
	@Autowired
	private ToCustomMapper tum;
	@Autowired
	private CustomMapper cm;
	@Autowired
	private SellMapper sm;
	
	@RequestMapping("/ToCustomList")
	public String findAllToCustom(HttpServletRequest request) {
		List<ToCustom> listtc = tum.findAll();
		request.setAttribute("list", listtc);
		return "/toCustomList";
	}

	@RequestMapping("/ToCustomModify")
	public String ToCustomModify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		String act = request.getParameter("act");
		
		// 测试初始值
		/* System.out.println("初始id:" + id);
		System.out.println("初始act:" + act);
		System.out.println("初始flag:" + flag);*/
		List<Custom> list = cm.selectCustomByType(2);
		// 保存
		request.setAttribute("customs", list);		
		List<Sell> list1 = sm.findAll();
		// 保存
		request.setAttribute("customss", list1);
		// 删除	
		if (flag != null) {
			//调用根据id删除的方法
			tum.deleteCustom(id);
			//转发
			return "redirect:/ToCustomList";
		}
		//判断(是点击的保存还是其他)
		if (act == null) {
					
			if (id == null) {
				// 添加
			} else {
				// 修改
				ToCustom p = tum.findById(id);
				request.setAttribute("custom", p);
				//转发到编辑界面
			}
			return "toCustomForm";
		}else {
			
			//获取保存时传递的数据
			String cbid = request.getParameter("cbid");
			String cid = request.getParameter("cid");
			String sid = request.getParameter("sid");
			String date = request.getParameter("date");
			double totalprice = Double.parseDouble(request.getParameter("totalprice"));
			// 实例化
			ToCustom p = new ToCustom();
			p.setCbid(cbid);
			Custom ce = new Custom();
			ce.setCid(cid);
			p.setCustom(ce);
			Sell s = new Sell();
			s.setSid(sid);
			p.setSell(s);
			p.setDate(date);
			p.setTotalprice(totalprice);
			
			//保存 添加
			if ("add".equals(act)) {
				//调用添加的方法
				tum.insert(p);
			} else if ("mdy".equals(act)) {
				//调用修改的方法
				tum.updateCustom(p);
			}
			
			//转发到查询所有销售退货的地址
			return "redirect:/ToCustomList";
		}
		
	}
}

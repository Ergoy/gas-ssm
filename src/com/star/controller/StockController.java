package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Stock;
import com.star.mapper.CustomMapper;
import com.star.mapper.StockMapper;


@Controller
public class StockController {
	@Autowired
	private StockMapper sm;
	@Autowired
	private CustomMapper cm;
	
	@RequestMapping("/StockList")
	public String findAllStock(HttpServletRequest request) {
		List<Stock> listpv = sm.findAll();
		request.setAttribute("list", listpv);
		return "/stockList";
	}
	@RequestMapping("/StockModify")
	public String StockModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		//获取判断语句name的值
		String act=request.getParameter("act");
		List<Custom> list=cm.selectCustomByType(2);
		//保存
		request.setAttribute("provider", list);
		//删除
		if (flag!=null) {
			//调用根据id删除的方法
			sm.deleteStock(id);
			//转发
			return "redirect:/StockList";
		}
		//判断(是点击的保存还是其他)
		if (act==null) {
			
			if(id==null) {
				//添加
			}else{
				//修改
				Stock s=sm.findById(id);
				request.setAttribute("stock", s);
			}
			//转发到编辑界面
			return "stockForm";
			
		}else {
			
			//获取保存时传递的数据
			String sid=request.getParameter("sid");
			String cid=request.getParameter("cid");
			String date=request.getParameter("date");
			double totalprice=Double.parseDouble(request.getParameter("totalprice"));
			String buyer=request.getParameter("buyer");
			//实例化Stock
			Stock s=new Stock();
			s.setSid(sid);
			//实例化custom
			Custom ce=new Custom();
			ce.setCid(cid);
			s.setCustom(ce);
			s.setDate(date);
			s.setTotalprice(totalprice);
			s.setBuyer(buyer);
			
			//保存 添加
			if("add".equals(act)) {
				//调用添加的方法
				sm.insert(s);
			}else if("mdy".equals(act)) {
				//调用修改的方法
				sm.updateStock(s);
			}
			
			//转发到查询所以采购信息的地址
			return "redirect:/StockList";
		}
	}
}


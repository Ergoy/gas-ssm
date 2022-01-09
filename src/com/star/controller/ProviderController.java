package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Provider;
import com.star.entity.Stock;
import com.star.mapper.CustomMapper;
import com.star.mapper.ProviderMapper;
import com.star.mapper.StockMapper;


@Controller
public class ProviderController {

	@Autowired
	private ProviderMapper pm;
	@Autowired
	private CustomMapper cm;
	@Autowired
	private StockMapper sm;
	
	@RequestMapping("/ProviderList")
	public String findAllProvider(HttpServletRequest request) {
		List<Provider> listpv = pm.findAll();
		request.setAttribute("list", listpv);
		return "/providerList";
	}
	@RequestMapping("/ProviderModify")
	public String ProviderModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		// 获取判断语句name的值
		String act=request.getParameter("act");
		
		//测试初始值
		/* System.out.println("初始id:"+id);
		System.out.println("初始act:"+act);
		System.out.println("初始flag:"+flag);*/
		List<Custom> list=cm.selectCustomByType(2);
		//保存
		request.setAttribute("providers", list);
		//获取采购单号信息
		List<Stock> list1=sm.findAll();
		//保存
		request.setAttribute("providerss", list1);	
		//删除
		if (flag!=null) {
			//调用根据id删除的方法
			pm.deleteProvider(id);
			// 转发
			return "redirect:/ProviderList";
		}
			//判断(是点击的保存还是其他)
			if (act==null) {
				
				if (id==null) {
					//添加
				} else {
					//修改
					Provider p=pm.findById(id);
					request.setAttribute("provider", p);
				}
				//转发到编辑界面
				return "providerForm";
			}else {
				
				//获取保存时传递的数据
				String pbid=request.getParameter("pbid");
				String cid=request.getParameter("cid");
				String sid=request.getParameter("sid");
				String date=request.getParameter("date");
				double totalprice=Double.parseDouble(request.getParameter("totalprice"));
				//实例化Provider
				Provider p=new Provider();
				p.setPbid(pbid);
				Custom ce=new Custom();
				ce.setCid(cid);
				p.setCustom(ce);
				Stock s=new Stock();
				s.setSid(sid);
				p.setStock(s);
				p.setDate(date);
				p.setTotalprice(totalprice);
				
				//保存 添加
				if ("add".equals(act)) {
					//调用添加的方法
					pm.insert(p);
				} else if("mdy".equals(act)) {
					//调用修改的方法
					pm.updateProvider(p);
				}
				
				//转发到查询所有采购退货的地址
				return "redirect:/ProviderList";
			}
		}
}
	


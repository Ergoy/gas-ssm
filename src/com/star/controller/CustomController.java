package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.mapper.CustomMapper;



@Controller
public class CustomController {

	@Autowired
	private CustomMapper cm;
	
	
	@RequestMapping("/CustList")
	public String findAllCustom(HttpServletRequest request) {
		int type=Integer.parseInt(request.getParameter("type"));
		List<Custom> listCM = cm.selectCustomByType(type);
		//设置数据到request
		//request.setAttribute("type", String.valueOf(type));
		request.setAttribute("type", type);
		request.setAttribute("list", listCM);
		return "/custList";
	}
	
	@RequestMapping("/CustModify")
	public String AddCustom(HttpServletRequest request) {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		//获取保存时的参数
		String act = request.getParameter("act");
		request.setAttribute("type", type);
		//判断(是点击的保存还是其他，(act可能是保存))
		if (act == null) {
			
			//判断(打开时是修改删除还是编辑)
			if ("d".equals(flag)) {
				//删除(调用根据id删除的方法)
				cm.deleteCustom(id);
				//重新查询
				if ("1".equals(type)) {
					return "redirect:/CustList?type=1";
				} else {
					return "redirect:/CustList?type=2";	
				}
			} else {
				if (id == null) {
					//添加(转发到添加界面)
				} else {
					//修改
					Custom ct = cm.selectCustomById(id);
					request.setAttribute("ct", ct);
				}
				//转发到编辑界面
				return "custForm";
			}

		}else {
			
			//获取保存时传递的数据
			String cid = request.getParameter("cid");
			String name = request.getParameter("name");
			String linkman = request.getParameter("linkman");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String remark = request.getParameter("remark");
			//创建对象 保存值
			Custom ct = new Custom();
			ct.setCid(cid);
			ct.setName(name);
			ct.setLinkman(linkman);
			ct.setAddr(addr);
			ct.setTel(tel);
			ct.setEmail(email);
			ct.setRemark(remark);
			
			//保存 添加
			if ("add".equals(act)) {
				int at = Integer.parseInt(request.getParameter("type"));
				ct.setType(at);
				//调用添加的方法
				int i = cm.addCustom(ct);
				
			} else if ("mdy".equals(act)) {
				//保存时是修改
				//调用修改的方法
				int i = cm.updateCustom(ct);
			}
			
			//转发到查询所有客户信息的地址
			return "redirect:/CustList?type="+type;	
			
		}
		
	}
}




package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.ToCustom;
import com.star.entity.ToCustomBack;
import com.star.mapper.GoodsMapper;
import com.star.mapper.ToCustomBackMapper;
import com.star.mapper.ToCustomMapper;



@Controller
public class ToCustomBackController {
	@Autowired
	private ToCustomBackMapper tcbm;	
	@Autowired
	private ToCustomMapper tcm;	
	@Autowired
	private GoodsMapper gm;	
	
	@RequestMapping("/ToCustomBackList")
	public String findAllTC(HttpServletRequest request) {
		//获取到id
		String id=request.getParameter("id");
		List<ToCustomBack> pb=tcbm.fandAll(id);
		//保存(把集合存储到request)
		request.setAttribute("list", pb);
		//转发(跳转到toCustomBackList.jsp界面)
		return "toCustomBackList";		
	}
	@RequestMapping("/ToCustomBackModify")
	public String ToCustomeModify(HttpServletRequest request) {
		//获取参数值
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		//获取重新查询的id
		String cbid = request.getParameter("cbid");
		//获取判断语句name的值
		String act = request.getParameter("act");
		List<ToCustom> list = tcm.findAll();
		request.setAttribute("backs", list);
		//第二个	
		List<Goods> lis = gm.findAll();
		request.setAttribute("good", lis);
		// 删除
		if (flag != null) {
			//调用根据id删除的方法
			tcbm.deleteCustom_back(id);
			List<ToCustomBack> pb = tcbm.fandAll(cbid);
			request.setAttribute("list", pb);
			// 转发
			return "toCustomBackList";
		}
		//判断(是点击的保存还是其他)
		if (act == null) {
			if (id == null) {
				// 新增
			} else {
				// 修改
				ToCustomBack pb = tcbm.findById(id);
				request.setAttribute("back", pb);
			}
			//转发到编辑界面
			return "toCustomBackForm";
		}else {	
			//获取保存时传递的数据
			String cbdid = request.getParameter("cbdid");
			String gid = request.getParameter("gid");
			double price = Double.parseDouble(request.getParameter("price"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			ToCustomBack pb = new ToCustomBack();
			pb.setCbdid(cbdid);
			ToCustom p = new ToCustom();
			p.setCbid(cbid);
			pb.setCust(p);
			Goods g = new Goods();
			g.setGid(gid);
			pb.setGoods(g);
			pb.setPrice(price);
			pb.setAmount(amount);
			
			//保存 添加
			if ("add".equals(act)) {
				//调用添加的方法
				tcbm.insert(pb);
			} else if ("mdy".equals(act)) {
				//调用修改的方法
				tcbm.updateCustom_back(pb);
			}
			
			List<ToCustomBack> pbs = tcbm.fandAll(cbid);
			request.setAttribute("list", pbs);
			//转发到查询地址
			return "toCustomBackList";
		}		
	}
}

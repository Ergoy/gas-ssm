package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Sell;
import com.star.entity.SellDetail;
import com.star.mapper.GoodsMapper;
import com.star.mapper.SellDetaiMapper;
import com.star.mapper.SellMapper;


@Controller
public class SellDetailController {
	@Autowired
	private SellDetaiMapper sdm;
	@Autowired
	private SellMapper sm;
	@Autowired
	private GoodsMapper gm;
	
	@RequestMapping("/SellDetailList")
	public String findAllSellD(HttpServletRequest request) {
		//查询所有数据(SellDetail集合中)
		//获取到id值
		String id= request.getParameter("id");
		List<SellDetail> sd=sdm.findAll(id);
		//保存(把集合存储到request)
		request.setAttribute("list", sd);
		//转发(跳转到sellDetailList.jsp界面)
		return "sellDetailList";
		
	}
	@RequestMapping("/SellDetailModify")
	public String SellDModify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		// 获取判断语句name的值
		String act = request.getParameter("act");
		// 获取重新查询id(删除)
		String ids = request.getParameter("ids");
		List<Sell> list = sm.findAll();
		// 测试初始值
		/* System.out.println("初始act:" + act);
		System.out.println("Modify初始Id:" + id);
		System.out.println("初始flag:"+flag); */
		
		// 获取销售id
		List<Goods> list2 = gm.findAll();
		// 保存
		request.setAttribute("sell", list);
		request.setAttribute("goods", list2);
		// 删除
		if (flag != null) {
			//调用根据id删除的方法
			sdm.deleteSellDetail(id);
			List<SellDetail> sd = sdm.findAll(ids);
			request.setAttribute("list", sd);
			// 转发
			return "sellDetailList";
		}
		//判断(是点击的保存还是其他)
		if (act == null) {
					
			if (id == null) {
				// 添加
			} else {
				// 修改
				SellDetail sd = sdm.findById(id);
				request.setAttribute("detail", sd);
			}
			    //转发到编辑界面
				return "sellDetailForm";
		}else {
			
			//获取保存时传递的数据
			String sdid = request.getParameter("sdid");
			String sid = request.getParameter("sid");
			String gid = request.getParameter("gid");
			int amount = Integer.parseInt(request.getParameter("amount"));
			double price = Double.parseDouble(request.getParameter("price"));
			// 实例化SellDetail
			SellDetail sd = new SellDetail();
			sd.setSdid(sdid);
			// 实例化Sell
			Sell s = new Sell();
			s.setSid(sid);
			sd.setSell(s);
			// 实例化Goods
			Goods g = new Goods();
			g.setGid(gid);
			sd.setGoods(g);
			sd.setAmount(amount);
			sd.setPrice(price);
			
			//保存 添加
			if ("add".equals(act)) {
				//调用添加的方法
				sdm.insert(sd);
			} else if ("mdy".equals(act)) {
				//调用修改的方法
				sdm.updateSellDetail(sd);
			}
			
			List<SellDetail> sds = sdm.findAll(sid);
			request.setAttribute("list", sds);
			//转发到查询的地址
			return "sellDetailList";
		}
	}

}

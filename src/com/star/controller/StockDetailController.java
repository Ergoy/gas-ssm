package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Stock;
import com.star.entity.StockDetail;
import com.star.mapper.GoodsMapper;
import com.star.mapper.StockDetailMapper;
import com.star.mapper.StockMapper;


@Controller
public class StockDetailController {
	@Autowired
	private StockDetailMapper sdm;
	@Autowired
	private StockMapper sm;	
	@Autowired
	private GoodsMapper gm;	
	
	@RequestMapping("/StockDetailList")
	public String findAllStockD(HttpServletRequest request) {
		//获取到id
		String id= request.getParameter("id");
		List<StockDetail> sd=sdm.findAll(id);
		request.setAttribute("list", sd);
		//转发(跳转到stockDetailList.jsp界面)
		return "stockDetailList";
	}
	@RequestMapping("/StockDetailModify")
	public String StockDModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		//获取重新查询的id
		String ids=request.getParameter("ids");
		//获取判断语句name的值
		String act=request.getParameter("act");	
		/* System.out.println("初始ids:"+ids);
		System.out.println("初始act:"+act);
		System.out.println("Modify初始Id:"+id);*/
		
		//获取采购id
		List<Stock> list=sm.findAll();
		//获取商品
		List<Goods> list2=gm.findAll();	
		request.setAttribute("stock", list);
		request.setAttribute("goods", list2);
		//删除
		if(flag!=null) {
			//调用根据id删除的方法
			sdm.deleteStockDetail(id);
			//重新查询
			List<StockDetail> lsd=sdm.findAll(ids);
			request.setAttribute("list", lsd);
			// 转发
			return "stockDetailList";
		}
		//判断(是点击的保存还是其他)
		if(act==null) {			
			if(id==null) {
				//添加
			}else {
				//修改
				StockDetail sd=sdm.findById(id);
				request.setAttribute("detail", sd);	
			}
			//转发到编辑界面
			return "stockDetailForm";
		}else {
			
			//获取保存时传递的数据
			String sdid=request.getParameter("sdid");
			String sid=request.getParameter("sid");
			String gid=request.getParameter("gid");
			int amount=Integer.parseInt(request.getParameter("amount"));
			double price=Double.parseDouble(request.getParameter("price"));
			//实例化StockDetail
			StockDetail sd=new StockDetail();
			sd.setSdid(sdid);
			//实例化Stock
			Stock s=new Stock();
			s.setSid(sid);
			sd.setStock(s);
			//实例化Goods
			Goods g=new Goods();
			g.setGid(gid);
			sd.setGoods(g);
			sd.setAmount(amount);
			sd.setPrice(price);
			
			//保存 添加
			if("add".equals(act)) {
				//调用添加的方法
				sdm.insert(sd);			
			}else if("mdy".equals(act)) {
				//调用修改的方法
				sdm.updateStockDetail(sd);				
			}
			
			//重新查询
			List<StockDetail> sds=sdm.findAll(sid);
			request.setAttribute("list", sds);
			//转发到查询的地址
			return "stockDetailList";
		}		
	}
}
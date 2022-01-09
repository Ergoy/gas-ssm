package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





import com.star.entity.Goods;
import com.star.entity.GoodsType;
import com.star.mapper.GoodsMapper;
import com.star.mapper.GoodsTypeMapper;


@Controller
public class GoodsController {
	@Autowired
	private GoodsMapper gm;
	@Autowired
	private GoodsTypeMapper gtm;
	
	@RequestMapping("/GoodsList")
	public String findAllGoods(HttpServletRequest request) {
		List<Goods> listGM = gm.findAll();
		request.setAttribute("list", listGM);
		return "/goodsList";
	}
	
	@RequestMapping("/GoodsModify")
	public String GoodsModefy(HttpServletRequest request) {
		//获取保存时的参数
		String act = request.getParameter("act");
		//获取参数【添加 修改(id) 删除(id,flag)
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");		
		//判断(是点击的保存还是其他，(act是保存))
		if (act == null) {	
			//添加
			//查询商品类别
			List<GoodsType> list=gtm.findAll();
			//保存
			request.setAttribute("type", list);	
			//判断(打开时是新增删除还是编辑)
			if ("d".equals(flag)) {
			    //删除(调用根据id删除的方法)
				gm.deleteGoods(id);
				return "redirect:/GoodsList";	
			} else {
				if (id == null) {
					//添加
				} else {
					//修改
					Goods g = gm.getGoodsById(id);
					request.setAttribute("goods", g);
				}		
				//转发到编辑界面
				return "goodsForm";
			}
			
		}	 else {
			
			//保存
			//获取添加数据时的参数
			String tid=request.getParameter("tid");
			String gid=request.getParameter("gid");
			String name=request.getParameter("name");
			String unit=request.getParameter("unit");
			//强制转换
			double pin=Double.parseDouble(request.getParameter("pin"));
			double pout=Double.parseDouble(request.getParameter("pout"));
			int amount=Integer.parseInt(request.getParameter("amount"));
			//创建对象
			Goods g=new Goods();
			g.setGid(gid);
			//封装对象
			GoodsType gt1=new GoodsType();
			gt1.setTid(tid);
			g.setGoodType(gt1);
			g.setName(name);
			g.setUnit(unit);
			g.setPin(pin);
			g.setPout(pout);
			g.setAmount(amount);
			
			if ("add".equals(act)) {
				//调用添加的方法
				int i = gm.addGoods(g);
						
			} else if ("mdy".equals(act)) {
				//保存时是修改(调用修改的方法)
				int i = gm.updateGoods(g);
				
			}
			//转发到查询所有商品信息的地址
			return "redirect:/GoodsList";
		}		

	}
	@RequestMapping("/GoodsModifys")
	public String GoodsModefies(HttpServletRequest request) {
		//获取添加数据时的参数
				String tid=request.getParameter("tid");
				String gid=request.getParameter("gid");
				String name=request.getParameter("name");
				String unit=request.getParameter("unit");
				//强制转换
				double pin=Double.parseDouble(request.getParameter("pin"));
				double pout=Double.parseDouble(request.getParameter("pout"));
				int amount=Integer.parseInt(request.getParameter("amount"));
				//创建对象
				Goods g=new Goods();
				g.setGid(gid);
				//封装对象
				GoodsType gt1=new GoodsType();
				gt1.setTid(tid);
				g.setGoodType(gt1);
				g.setName(name);
				g.setUnit(unit);
				g.setPin(pin);
				g.setPout(pout);
				g.setAmount(amount);
			
				//创建新增对象(addGoods是dao层中的新增对象)
				int ag=gm.addGoods(g);

				//打开添加的界面
				//请求到重新查询所有类别的servlet（如果有参数直接跳转到主界面GoodsList 重新查询）
				return "redirect:/GoodsList";
	}
}

		
	
		
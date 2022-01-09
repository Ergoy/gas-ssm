package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Provider;
import com.star.entity.ProviderBack;
import com.star.mapper.GoodsMapper;
import com.star.mapper.ProviderBackMapper;
import com.star.mapper.ProviderMapper;



@Controller
public class ProviderBackController {
	
	@Autowired
	private ProviderBackMapper pbm;
	@Autowired
	private ProviderMapper pm;
	@Autowired
	private GoodsMapper gm;
	
	@RequestMapping("/ProviderBackList")
	public String findAllProviderBack(HttpServletRequest request) {
		String id=request.getParameter("id");
		List<ProviderBack> pb=pbm.fandAll(id);
		//保存(把集合存储到request)
		request.setAttribute("list", pb);
		//转发(跳转到providerBackList.jsp界面)
		return "providerBackList";
	}
	@RequestMapping("/ProviderBackModify")
	public String ProviderBackModify(HttpServletRequest request) {
		//获取参数
				String id=request.getParameter("id");
				String flag=request.getParameter("flag");
				// 获取判断语句name的值
				String act=request.getParameter("act");
				// 获取重新查询id(删除)
				String pbid=request.getParameter("pbid");
				
				//测试数据
				/* System.out.println("初始act:"+act);
				System.out.println("初始id:"+id);
				System.out.println("外键pbid:"+pbid);
				System.out.println("flag:"+flag); */
				
				//获取俩个外键的下拉框
				//第一个
				List<Provider> list=pm.findAll();
				request.setAttribute("backs",list);
				//第二个
				List<Goods> lis=gm.findAll();
				request.setAttribute("good", lis);
				//删除
				if (flag!=null) {
					//调用根据id删除的方法
					pbm.deleteProvider_back(id);
					List<ProviderBack> pb=pbm.fandAll(pbid);
					request.setAttribute("list", pb);
					//转发
					return "providerBackList";
				}
				
				//判断(是点击的保存还是其他)
				if (act==null) {
					
					if (id==null) {
						//新增
					} else {
						//修改
						ProviderBack pb=pbm.findById(id);
						request.setAttribute("back", pb);
					}
					//转发到编辑界面
					return "providerBackForm";
				
				} else {
					
					//获取保存时传递的数据
					String pbdid=request.getParameter("pbdid");
					String gid=request.getParameter("gid");
					double price=Double.parseDouble(request.getParameter("price")) ;
					int amount=Integer.parseInt(request.getParameter("amount")) ;
					//实例化ProviderBack
					ProviderBack pb=new ProviderBack();
					pb.setPbdid(pbdid);
					//实例化Provider
					Provider p=new Provider();
					p.setPbid(pbid);
					pb.setProvider(p);
					//实例化Goods
					Goods g=new Goods();
					g.setGid(gid);
					pb.setGoods(g);
					pb.setPrice(price);
					pb.setAmount(amount);
					
					//保存 添加
					if("add".equals(act)) {
						//调用添加的方法
						pbm.insert(pb);
					}else if("mdy".equals(act)){
						//调用修改的方法
						pbm.updateProvider_back(pb);
					}
					
					List<ProviderBack> pbs=pbm.fandAll(pbid);
					request.setAttribute("list", pbs);
					//转发到查询的地址
					return "providerBackList";
				}
	}

}
